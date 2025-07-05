package com.senac.srsharp.model;

import jakarta.persistence.Entity;
import java.math.BigDecimal;
import lombok.Data;

/**
 *
 * @author John
 */
@Data
@Entity
public class Afiliado extends Usuario {

    private BigDecimal saldoDisponivel;

    private Integer codigoRegiao;

}
