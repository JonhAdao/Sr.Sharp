package com.senac.srsharp.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataSolicitacao;
    private String status;

    @ManyToOne
    private Usuario usuario;

    @ManyToMany
    private List<Servico> servicos;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<Pagamento> pagamentos;

    public Pedido() {
    }

    // Getters e Setters
}
