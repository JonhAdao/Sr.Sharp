package com.senac.srsharp.model;

import com.senac.srsharp.enums.MeioPagamento;
import com.senac.srsharp.enums.StatusPagamento;
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

    private BigDecimal valorTotal;
    private BigDecimal valorEmpresa;
    private BigDecimal valorAfiliado;
    private LocalDateTime dataPagamento;
    private MeioPagamento formaPagamento;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusPagamento statusPagamento;

    @ManyToOne
    private Pedido pedido;

    public Pagamento() {
    }

}
