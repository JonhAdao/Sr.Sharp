package com.senac.srsharp.service;

import com.senac.srsharp.model.Servico;
import com.senac.srsharp.repository.ServicoRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author John
 */
@Service
public class ServicoService {

    @Autowired
    ServicoRepository servicoRepository;

    // 🔍 Buscar todos os serviços
    public List<Servico> listarTodos() {
        return servicoRepository.findAll();
    }

    // 🔍 Buscar serviço por ID
    public Servico buscarPorId(Long id) {
        return servicoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Serviço não encontrado com ID: " + id));
    }

    // 💾 Criar novo serviço
    public Servico salvar(Servico servico) {
        if (servicoRepository.existsByNome(servico.getNome())) {
            throw new IllegalArgumentException("Já existe um serviço com esse nome.");
        }
        return servicoRepository.save(servico);
    }

    // 📝 Atualizar um serviço
    public Servico atualizar(Long id, Servico servicoAtualizado) {
        Servico servicoExistente = buscarPorId(id);
        servicoExistente.setNome(servicoAtualizado.getNome());
        servicoExistente.setObservacao(servicoAtualizado.getObservacao());
        servicoExistente.setPreco(servicoAtualizado.getPreco());
        return servicoRepository.save(servicoExistente);
    }

    // ❌ Deletar serviço
    public void deletar(Long id) {
        if (!servicoRepository.existsById(id)) {
            throw new EntityNotFoundException("Serviço com ID " + id + " não encontrado.");
        }
        servicoRepository.deleteById(id);
    }
}
