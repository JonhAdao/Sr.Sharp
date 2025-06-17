package com.senac.srsharp.model;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpfOuCnpj;
    private String email;
    private String senha;
    private String tipo; // CLIENTE ou AFILIADO

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    @OneToOne(cascade = CascadeType.ALL)
    private Contato contato;

    public Usuario() {
    }

    // Getters e Setters
}
