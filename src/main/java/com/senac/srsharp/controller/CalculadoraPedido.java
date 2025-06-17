package com.senac.srsharp.controller;

/**
 *
 * @author John
 */
import com.senac.srsharp.model.Servico;
import java.util.List;

public class CalculadoraPedido {

    public static double calcularTotal(List<Servico> servicos) {
        double total = 0.0;

        if (servicos != null) {
            for (Servico servico : servicos) {
                if (servico != null && servico.getPreco() != 0) {
                    total += servico.getPreco();
                }
            }
        }

        return total;
    }
}
