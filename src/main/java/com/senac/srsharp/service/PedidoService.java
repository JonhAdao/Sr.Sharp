package com.senac.srsharp.service;

import com.senac.srsharp.enums.StatusPedido;
import com.senac.srsharp.model.Afiliado;
import com.senac.srsharp.model.Pedido;
import com.senac.srsharp.model.Servico;
import com.senac.srsharp.repository.AfiliadoRepository;
import com.senac.srsharp.repository.PedidoRepository;
import com.senac.srsharp.repository.ServicoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Transactional
    public Pedido criarPedido(Long afiliadoId, List<Long> servicoIds) {
        // 1. Buscar afiliado
        Afiliado afiliado = afiliadoRepository.findById(afiliadoId)
                .orElseThrow(() -> new EntityNotFoundException("Afiliado não encontrado"));

        // 2. Buscar serviços
        List<Servico> servicos = servicoRepository.findAllById(servicoIds);
        if (servicos.isEmpty()) {
            throw new IllegalArgumentException("Nenhum serviço válido informado.");
        }

        // 3. Criar pedido
        Pedido pedido = new Pedido();
        pedido.setAfiliado(afiliado);
        pedido.setServicos(servicos); // Supondo relacionamento List<Servico>
        pedido.setDataSolicitacao(LocalDateTime.now());
        pedido.setStatus(StatusPedido.AGUARDANDO_PAGAMENTO);

        // 4. Salvar e retornar
        return pedidoRepository.save(pedido);
    }

}
