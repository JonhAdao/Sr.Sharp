package com.senac.srsharp.service;

import com.senac.srsharp.model.Afiliado;
import com.senac.srsharp.repository.AfiliadoRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author John
 */
public class AdministradorService {

    @Autowired
    AfiliadoRepository afiliadoRepository;

    // 🔍 Buscar todos os serviços
    public List<Afiliado> listarTodos() {
        return afiliadoRepository.findAll();
    }

    // 🔍 Buscar serviço por ID
    public Afiliado buscarPorId(Long id) {
        return afiliadoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Afiliado não encontrado com ID: " + id));
    }

    // 💾 Criar novo serviço
    public Afiliado salvar(Afiliado afiliado) {
        if (afiliadoRepository.existsByNome(afiliado.getNome())) {
            throw new IllegalArgumentException("Já existe um afiliado com esse nome.");
        }
        return afiliadoRepository.save(afiliado);
    }

    // 📝 Atualizar um Afiliado
    public Afiliado atualizar(Long id, Afiliado afiliadoAtualizado) {
        Afiliado afiliadoExistente = buscarPorId(id);
        afiliadoExistente.setNome(afiliadoAtualizado.getNome());
           return afiliadoRepository.save(afiliadoAtualizado);
    }

    // ❌ Deletar serviço
    public void deletar(Long id) {
        if (!afiliadoRepository.existsById(id)) {
            throw new EntityNotFoundException("Serviço com ID " + id + " não encontrado.");
        }
        afiliadoRepository.deleteById(id);
    }

}
