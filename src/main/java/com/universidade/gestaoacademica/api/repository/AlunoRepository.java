package com.universidade.gestaoacademica.api.repository;

import com.universidade.gestaoacademica.api.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
