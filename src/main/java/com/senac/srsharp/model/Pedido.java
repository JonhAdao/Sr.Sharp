package com.senac.srsharp.model;

import com.senac.srsharp.enums.StatusPedido;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataSolicitacao;
    
    private String observacao;

    @ManyToOne
    private Afiliado afiliado;

    @ManyToMany
    private List<Servico> servicos;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<Pagamento> pagamentos;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusPedido status;

}
