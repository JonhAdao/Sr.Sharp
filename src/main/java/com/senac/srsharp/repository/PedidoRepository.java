package com.senac.srsharp.repository;

import com.senac.srsharp.enums.StatusPedido;
import com.senac.srsharp.model.Pedido;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 *
 * @author John
 */
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>, JpaSpecificationExecutor<Pedido> {

    List<Pedido> findByAfiliadoId(Long afiliadoId);

    List<Pedido> findByAfiliadoIdAndStatus(Long afiliadoId, StatusPedido status);

    List<Pedido> findBydataSolicitacaoBetween(LocalDate start, LocalDate end);

}
