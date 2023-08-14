package com.universidade.gestaoacademica.api.repository;

import com.universidade.gestaoacademica.api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByLogin(String email);
}
