package com.universidade.gestaoacademica.api.repository;

import com.universidade.gestaoacademica.api.model.Disciplina;
import com.universidade.gestaoacademica.api.model.MatrizCurricular;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatrizCurricularRepository extends JpaRepository<MatrizCurricular, Long> {

    @Query("SELECT d " +
            "FROM MatrizCurricular m " +
            "JOIN Disciplina d ON m.disciplinaId = d.id " +
            "WHERE m.curso = :cursoNome")
    List<Disciplina> findDisciplinasByCursoNome(String cursoNome);

    @Query("SELECT DISTINCT m.curso FROM MatrizCurricular m")
    List<String> findCursosNaoRepetidos();

    void deleteByCurso(String curso);

    List<MatrizCurricular> findByCurso(String curso);

}
