package com.universidade.gestaoacademica.api.repository;

import com.universidade.gestaoacademica.api.model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
}
