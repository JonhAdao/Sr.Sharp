package com.senac.srsharp.service;

import com.senac.srsharp.enums.MeioPagamento;
import com.senac.srsharp.enums.StatusPedido;
import com.senac.srsharp.model.Afiliado;
import com.senac.srsharp.model.Pagamento;
import com.senac.srsharp.model.Pedido;
import com.senac.srsharp.model.Servico;
import com.senac.srsharp.repository.AfiliadoRepository;
import com.senac.srsharp.repository.PedidoRepository;
import com.senac.srsharp.repository.ServicoRepository;
import com.senac.srsharp.util.PedidoEspecificacao;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

/**
 *
 * @author John
 */
@Service
public class PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    private AfiliadoRepository afiliadoRepository;

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    PagamentoService pagamentoService;

    @Autowired
    ColetaService coletaService;

    // Método que verifica se o Afiliado que realizou o pedido existe
    private Afiliado buscarAfiliadoOuErro(Long afiliadoId) {
        return afiliadoRepository.findById(afiliadoId)
                .orElseThrow(() -> new EntityNotFoundException("Afiliado não encontrado"));
    }

    // Método que verifica se os serviços escolhidos existem
    private List<Servico> buscarServicosOuErro(List<Long> ids) {
        List<Servico> servicos = servicoRepository.findAllById(ids);
        if (servicos.isEmpty() || servicos.size() != ids.size()) {
            throw new IllegalArgumentException("Um ou mais serviços não foram encontrados.");
        }
        return servicos;
    }

    //Método que cria o pedido parcialmente, faltando o campo de pagamento
    private Pedido montarPedido(Afiliado afiliado, List<Servico> servicos, String observacao) {
        Pedido pedido = new Pedido();
        pedido.setAfiliado(afiliado);
        pedido.setServicos(servicos);
        pedido.setObservacao(observacao);
        pedido.setDataSolicitacao(LocalDateTime.now());
        pedido.setStatus(StatusPedido.AGUARDANDO_PAGAMENTO);
        return pedido;
    }

    // Método que cria o pedido completo, incluindo Pagamento.
    @Transactional
    public Pedido criarPedido(Long afiliadoId, List<Long> servicoIds, String observacao, MeioPagamento meioPagamento) {
        Afiliado afiliado = buscarAfiliadoOuErro(afiliadoId);
        List<Servico> servicos = buscarServicosOuErro(servicoIds);

        Pedido pedido = montarPedido(afiliado, servicos, observacao);
        Pagamento pagamento = pagamentoService.gerarPagamentoTotal(pedido, servicos, meioPagamento);

        pedido.setPagamentos(List.of(pagamento));
        coletaService.agendarColeta(pedido);
        return pedidoRepository.save(pedido);

    }

    public List<Pedido> buscarPedidosComFiltro(Long afiliadoId, StatusPedido status,
            LocalDate inicio, LocalDate fim) {
        Specification<Pedido> spec = PedidoEspecificacao.porAfiliado(afiliadoId)
                .and(PedidoEspecificacao.porStatus(status))
                .and(PedidoEspecificacao.entreDatas(inicio, fim));

        return pedidoRepository.findAll(spec);
    }

}
