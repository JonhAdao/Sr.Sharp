package com.senac.srsharp.repository;

import com.senac.srsharp.model.Administrador;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author John
 */
@Repository

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {

    Optional<Administrador> findByEmail(String email);

    List<Administrador> findByNomeContainingIgnoreCase(String name);
}
