package com.universidade.gestaoacademica.api.repository;

import com.universidade.gestaoacademica.api.model.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {
}
