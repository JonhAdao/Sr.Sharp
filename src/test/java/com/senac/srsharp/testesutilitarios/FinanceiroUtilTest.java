package com.senac.srsharp.testesutilitarios;

/**
 *
 * @author John
 */
import com.senac.srsharp.util.FinanceiroUtil;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class FinanceiroUtilTest {

    @Test
    void deveCalcularRepasseCorretamente() {
        // Arrange
        BigDecimal valorCobrado = new BigDecimal("15.00");
        BigDecimal valorBaseEmpresa = new BigDecimal("6.00");

        // Act
        BigDecimal repasse = FinanceiroUtil.calcularRepasse(valorCobrado, valorBaseEmpresa);

        // Assert
        assertEquals(new BigDecimal("9.00"), repasse);
    }

    @Test
    void deveRetornarZeroSeValoresForemIguais() {
        BigDecimal valorCobrado = new BigDecimal("6");
        BigDecimal valorBase = new BigDecimal("6");

        BigDecimal repasse = FinanceiroUtil.calcularRepasse(valorCobrado, valorBase);

        assertEquals(BigDecimal.ZERO, repasse);
    }
}
