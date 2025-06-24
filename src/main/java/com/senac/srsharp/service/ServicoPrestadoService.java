package com.senac.srsharp.service;

import com.senac.srsharp.model.Servico;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author John
 */
public class ServicoPrestadoService {

    private List<Servico> listaServicos = new ArrayList<>();

    public void cadastrarServico(Servico servico) {
        listaServicos.add(servico);
    }

    public List<Servico> listarServicos() {
        return listaServicos;
    }

    public Servico buscarServico(int id) {
        for (Servico servico : listaServicos) {
            if (servico.getId() == id) {
                return servico;
            }
        }
        System.out.println(" Nenhum serviço com ID " + id + " foi encontrado.");
        return null;
    }

    public Servico atualizarServico(int id, String nome, Double preço) {
        Servico servicoAtualizado = buscarServico(id);
        if (servicoAtualizado != null) {
            servicoAtualizado.setNome(nome);
            servicoAtualizado.setPreco(preço);
            System.out.println("\n Serviço Atualizado com Sucesso ");
        }
        return servicoAtualizado;
    }

    public Servico excluirServico(int idServico) {
        return listaServicos.remove(idServico);
    }
}
