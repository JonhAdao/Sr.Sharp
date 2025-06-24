package com.senac.srsharp.repository;

import com.senac.srsharp.model.Servico;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author John
 */
@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {

    List<Servico> findByNomeContainingIgnoreCase(String name);

    boolean existsByNome(String name);
}
