package com.senac.srsharp.repository;

import com.senac.srsharp.enums.StatusPagamento;
import com.senac.srsharp.model.Pagamento;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author John
 */
@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

    List<Pagamento> findByStatusPagamento(StatusPagamento status);

    List<Pagamento> findByPedidoAfiliadoId(Long afiliadoId);

    List<Pagamento> findByStatusPagamentoAndPedidoAfiliadoId(StatusPagamento status, Long afiliadoId);
}
