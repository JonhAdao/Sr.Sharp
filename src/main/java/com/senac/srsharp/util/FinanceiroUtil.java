package com.senac.srsharp.util;

import java.math.BigDecimal;

/**
 *
 * @author John
 */
public class FinanceiroUtil {

    public static BigDecimal calcularRepasse(BigDecimal valorCobradoAfiliado, BigDecimal valorBaseEmpresa) {
        return valorCobradoAfiliado.subtract(valorBaseEmpresa);
    }
}
