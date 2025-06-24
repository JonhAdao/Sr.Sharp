package com.senac.srsharp.repository;

import com.senac.srsharp.model.Afiliado;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author John
 */
@Repository
public interface AfiliadoRepository extends JpaRepository<Afiliado, Long> {

    Optional<Afiliado> findByEmail(String email);

    List<Afiliado> findBySaldoDisponivelGreaterThan(BigDecimal value);

    List<Afiliado> findByNomeContainingIgnoreCase(String name);
}
