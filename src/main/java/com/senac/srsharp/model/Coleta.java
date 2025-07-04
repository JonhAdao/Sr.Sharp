package com.senac.srsharp.model;

import com.senac.srsharp.enums.StatusColeta;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@Entity
public class Coleta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataAgendada;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusColeta statusColeta;

    @ManyToOne
    private Afiliado responsavel;

    @OneToOne
    private Pedido pedido;

}
