package com.universidade.gestaoacademica.api.repository;

import com.universidade.gestaoacademica.api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByMatricula(Integer matricula);

    UserDetails findByLogin(String login);

    boolean existsByLogin(String login);
}
