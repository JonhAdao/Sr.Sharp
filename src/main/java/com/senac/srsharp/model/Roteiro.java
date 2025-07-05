package com.senac.srsharp.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Data;

/**
 *
 * @author John
 */
@Data
@Entity
public class Roteiro {

    @Id
    @GeneratedValue
    private Long id;

    private String nome; // "Motoqueiro A"

    @OneToMany(cascade = CascadeType.ALL)
    private List<RegiaoRoteiro> regioes;
}
