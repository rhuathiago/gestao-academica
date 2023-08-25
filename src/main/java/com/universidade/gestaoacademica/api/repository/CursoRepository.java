package com.universidade.gestaoacademica.api.repository;

import com.universidade.gestaoacademica.api.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
}
