package com.senac.srsharp.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String formaPagamento;
    private Double valor;
    private LocalDateTime dataPagamento;
    private Boolean confirmado;

    @ManyToOne
    private Pedido pedido;

    public Pagamento() {
    }

    // Getters e Setters
}
