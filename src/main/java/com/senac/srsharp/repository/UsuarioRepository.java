package com.senac.srsharp.repository;

import com.senac.srsharp.model.Usuario;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author John
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

    boolean existsByCpfOuCnpj(String cpfOuCnpj);

    List<Usuario> findByPerfil(String perfil); // Se o campo "perfil" existir
}
