package com.senac.srsharp.util;

import com.senac.srsharp.enums.StatusPedido;
import com.senac.srsharp.model.Pedido;
import jakarta.persistence.criteria.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.springframework.data.jpa.domain.Specification;

/**
 *
 * @author John
 */
public class PedidoEspecificacao {

    public static Specification<Pedido> porAfiliado(Long afiliadoId) {
        return (root, query, builder)
                -> afiliadoId == null ? null : builder.equal(root.get("afiliado").get("id"), afiliadoId);
    }

    public static Specification<Pedido> porStatus(StatusPedido status) {
        return (root, query, builder)
                -> status == null ? null : builder.equal(root.get("status"), status);
    }

    public static Specification<Pedido> entreDatas(LocalDate inicio, LocalDate fim) {
        return (root, query, builder) -> {
            if (inicio == null && fim == null) {
                return null;
            }

            Path<LocalDateTime> dataSolicitacao = root.get("dataSolicitacao");

            if (inicio != null && fim != null) {
                return builder.between(dataSolicitacao, inicio.atStartOfDay(), fim.atTime(23, 59, 59));
            } else if (inicio != null) {
                return builder.greaterThanOrEqualTo(dataSolicitacao, inicio.atStartOfDay());
            } else {
                return builder.lessThanOrEqualTo(dataSolicitacao, fim.atTime(23, 59, 59));
            }
        };
    }
}
