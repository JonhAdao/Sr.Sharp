package com.senac.srsharp.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@Entity
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String formaPagamento;
    private BigDecimal valorTotal;
    private BigDecimal valorEmpresa;
    private BigDecimal valorAfiliado;
    private LocalDateTime dataPagamento;
    private Boolean confirmado;

    @ManyToOne
    private Pedido pedido;

    public Pagamento() {
    }

}
