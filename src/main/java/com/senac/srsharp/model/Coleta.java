package com.senac.srsharp.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.Data;

@Data
@Entity
public class Coleta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataAgendada;
    private String status;

    @ManyToOne
    private Afiliado responsavel;

    @OneToOne
    private Pedido pedido;

}
