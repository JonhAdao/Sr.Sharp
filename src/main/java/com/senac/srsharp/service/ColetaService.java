package com.senac.srsharp.service;

import com.senac.srsharp.enums.StatusColeta;
import com.senac.srsharp.model.Afiliado;
import com.senac.srsharp.model.Coleta;
import com.senac.srsharp.model.Pedido;
import com.senac.srsharp.repository.AfiliadoRepository;
import com.senac.srsharp.repository.ColetaRepository;
import jakarta.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author John
 */
@Service
public class ColetaService {

    @Autowired
    ColetaRepository coletaRepository;

    @Autowired
    private AfiliadoRepository afiliadoRepository;

    public Coleta agendarColeta(Pedido pedido) {
        Coleta coleta = new Coleta();
        coleta.setPedido(pedido);
        coleta.setResponsavel(pedido.getAfiliado());
        coleta.setStatusColeta(StatusColeta.PENDENTE);
        coleta.setDataAgendada(pedido.getDataSolicitacao());

        return coletaRepository.save(coleta);
    }

    public void cancelarColeta(Long id) {
        Coleta coleta = coletaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Coleta com ID " + id + " não encontrado."));
        coleta.setStatusColeta(StatusColeta.CANCELADA);
        coletaRepository.save(coleta);

    }

    public Coleta reagendarColeta(Long id, LocalDateTime novaData) {
        Coleta coleta = coletaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Coleta com ID " + id + " não encontrado."));

        coleta.setDataAgendada(novaData);

        return coletaRepository.save(coleta);

    }

    public List<Coleta> buscarColetasPorAfiliado(Long afiliadoId) {
        Afiliado afiliadoEncontrado = afiliadoRepository.findById(afiliadoId)
                .orElseThrow(() -> new EntityNotFoundException("Afiliado com ID " + afiliadoId + " não encontrado."));

        return coletaRepository.findByResponsavelId(afiliadoEncontrado.getId());

    }
}
