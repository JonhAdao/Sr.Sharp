package com.senac.srsharp.model;

import jakarta.persistence.*;

@Entity
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String telefone;
    private String whatsapp;
    private String observacoes;

    public Contato() {
    }

    // Getters e Setters
}
