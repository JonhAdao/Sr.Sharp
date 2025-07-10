package com.senac.srsharp.dto;

import com.senac.srsharp.model.Contato;
import com.senac.srsharp.model.Endereco;
import java.math.BigDecimal;
import lombok.Data;

/**
 *
 * @author John
 */
@Data
public class AfiliadoUpdateDto {

    private String nome;
    private Endereco endereco;
    private Contato contato;
    private String cpf;
    private Integer codigoRegiao;
    private BigDecimal saldoDisponivel;

}
