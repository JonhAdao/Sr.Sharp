package com.senac.srsharp.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String observacao;
    private Double preco;

    public Servico(int id, String nome, String observacao, Double preco) {
        this.id = id;
        this.nome = nome;
        this.observacao = observacao;
        this.preco = preco;
    }


}
