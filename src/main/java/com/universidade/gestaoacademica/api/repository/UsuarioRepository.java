package com.universidade.gestaoacademica.api.repository;

import com.universidade.gestaoacademica.api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
