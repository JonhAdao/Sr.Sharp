package com.senac.srsharp.repository;

import com.senac.srsharp.model.Coleta;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author John
 */
public interface ColetaRepository extends JpaRepository<Coleta, Long> {

    List<Coleta> findByResponsavelId(Long AfiliadoId);
}
