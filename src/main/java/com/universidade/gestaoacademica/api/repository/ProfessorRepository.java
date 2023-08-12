package com.universidade.gestaoacademica.api.repository;

import com.universidade.gestaoacademica.api.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
