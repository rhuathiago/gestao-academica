package com.universidade.gestaoacademica.api.repository;

import com.universidade.gestaoacademica.api.model.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Long> {
}
