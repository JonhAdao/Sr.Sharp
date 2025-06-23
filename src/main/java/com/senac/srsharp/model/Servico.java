package com.senac.srsharp.model;

// import jakarta.persistence.*;
// @Entity
public class Servico {

    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descricao;
    private Double preco;

    public Servico() {
    }

    public Servico(int id, String descricao, Double preco) {
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
    }


    // Getters e Setters
    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

}
