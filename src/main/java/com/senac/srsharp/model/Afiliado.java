package com.senac.srsharp.model;

import jakarta.persistence.Entity;
import java.math.BigDecimal;

/**
 *
 * @author John
 */
@Entity
public class Afiliado extends Usuario {

    private BigDecimal saldoDisponivel;

}
