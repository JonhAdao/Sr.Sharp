package com.senac.srsharp.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Coleta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataAgendada;
    private String status;

    @ManyToOne
    private Usuario responsavel;

    @OneToOne
    private Pedido pedido;

    public Coleta() {
    }

    // Getters e Setters
}
