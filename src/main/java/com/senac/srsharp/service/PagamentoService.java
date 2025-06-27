package com.senac.srsharp.service;

import com.senac.srsharp.enums.MeioPagamento;
import com.senac.srsharp.enums.StatusPagamento;
import com.senac.srsharp.model.Pagamento;
import com.senac.srsharp.model.Pedido;
import com.senac.srsharp.model.Servico;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Service;

/**
 *
 * @author John
 */
@Service
public class PagamentoService {

    public Pagamento gerarPagamentoTotal(Pedido pedido, List<Servico> servicos, MeioPagamento meio) {
        BigDecimal total = servicos.stream()
                .map(Servico::getPreco)
                .filter(Objects::nonNull)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        Pagamento pagamento = new Pagamento();
        pagamento.setPedido(pedido);
        pagamento.setValorTotal(total);
        pagamento.setStatusPagamento(StatusPagamento.PENDENTE);
        pagamento.setFormaPagamento(meio);
        return pagamento;
    }

}
