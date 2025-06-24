package com.senac.srsharp.model;

import com.senac.srsharp.enums.PerfilUsuario;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpfOuCnpj;
    private String email;
    private String senha;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PerfilUsuario perfil; // CLIENTE ou AFILIADO

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    @OneToOne(cascade = CascadeType.ALL)
    private Contato contato;

}
