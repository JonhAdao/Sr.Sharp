package com.senac.srsharp.model;

import com.senac.srsharp.enums.Turno;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

/**
 *
 * @author John
 */
@Data
@Entity
public class RegiaoRoteiro {

    @Id
    @GeneratedValue
    private Long id;

    private Integer codigoRegiao;

    @Enumerated(EnumType.STRING)
    private Turno turnoColeta;
}
