package com.senac.srsharp.service;

import com.senac.srsharp.enums.StatusColeta;
import com.senac.srsharp.model.Coleta;
import com.senac.srsharp.model.Pedido;
import com.senac.srsharp.repository.ColetaRepository;
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

    public Coleta agendarColeta(Pedido pedido) {
        Coleta coleta = new Coleta();
        coleta.setPedido(pedido);
        coleta.setResponsavel(pedido.getAfiliado());
        coleta.setStatusColeta(StatusColeta.PENDENTE);
        coleta.setDataAgendada(pedido.getDataSolicitacao());

        return coletaRepository.save(coleta);
    }
}
