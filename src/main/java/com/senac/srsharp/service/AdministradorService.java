package com.senac.srsharp.service;

import com.senac.srsharp.dto.AfiliadoUpdateDto;
import com.senac.srsharp.model.Afiliado;
import com.senac.srsharp.model.Contato;
import com.senac.srsharp.model.Endereco;
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

    // Atualizar Endereço
    private void atualizarEndereco(Endereco original, Endereco atualizado) {
        if (atualizado.getRua() != null) {
            original.setRua(atualizado.getRua());
        }
        if (atualizado.getCep() != null) {
            original.setCep(atualizado.getCep());
        }
        if (atualizado.getNumero() != null) {
            original.setNumero(atualizado.getNumero());
        }
        if (atualizado.getBairro() != null) {
            original.setBairro(atualizado.getBairro());
        }
        if (atualizado.getEstado() != null) {
            original.setEstado(atualizado.getEstado());
        }
        if (atualizado.getCidade() != null) {
            original.setCidade(atualizado.getCidade());
        }

    }

    // Atualizar Contato
    private void atualizarContato(Contato original, Contato atualizado) {
        if (atualizado.getTelefone() != null) {
            original.setTelefone(atualizado.getTelefone());
        }
        if (atualizado.getWhatsapp() != null) {
            original.setWhatsapp(atualizado.getWhatsapp());
        }

        if (atualizado.getObservacoes() != null) {
            original.setObservacoes(atualizado.getObservacoes());
        }
    }

    // 📝 Atualizar um Afiliado
    public Afiliado atualizar(Long id, AfiliadoUpdateDto dto) {
        Afiliado afiliado = buscarPorId(id);

        if (dto.getNome() != null) {
            afiliado.setNome(dto.getNome());
        }

        if (dto.getCpf() != null) {
            afiliado.setCpfOuCnpj(dto.getCpf());
        }

        if (dto.getCodigoRegiao() != null) {
            afiliado.setCodigoRegiao(dto.getCodigoRegiao());
        }

        if (dto.getSaldoDisponivel() != null) {
            afiliado.setSaldoDisponivel(dto.getSaldoDisponivel());
        }

        if (dto.getEndereco() != null) {
            atualizarEndereco(afiliado.getEndereco(), dto.getEndereco());
        }

        if (dto.getContato() != null) {
            atualizarContato(afiliado.getContato(), dto.getContato());
        }

        return afiliadoRepository.save(afiliado);
    }

    // ❌ Deletar serviço
    public void deletar(Long id) {
        if (!afiliadoRepository.existsById(id)) {
            throw new EntityNotFoundException("Serviço com ID " + id + " não encontrado.");
        }
        afiliadoRepository.deleteById(id);
    }

}
