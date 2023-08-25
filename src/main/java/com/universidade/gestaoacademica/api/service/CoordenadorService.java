package com.universidade.gestaoacademica.api.service;

import com.universidade.gestaoacademica.api.model.Curso;
import com.universidade.gestaoacademica.api.model.Disciplina;
import com.universidade.gestaoacademica.api.model.MatrizCurricular;

import java.util.List;

public interface CoordenadorService {
    Disciplina criarDisciplina(Disciplina disciplina);
    void excluirDisciplina(Long id);
    Disciplina atualizarDisciplina(Long id, Disciplina disciplina);
    List<Disciplina> listarDisciplinas();
    Disciplina visualizarDisciplina(Long id);
    MatrizCurricular criarMatrizCurricular(MatrizCurricular matrizCurricular);
    void excluirMatrizCurricular(Long id);
    MatrizCurricular atualizarMatrizCurricular(Long id, MatrizCurricular matrizCurricular);
    List<MatrizCurricular> listarMatrizesCurriculares();
    MatrizCurricular visualizarMatrizCurricular(Long id);
    List<Curso> listarCursos();
    Curso criarCurso(Curso curso);
    Curso atualizarCurso(Long id, Curso curso);
    Curso findCursoById(Long id);
    void excluirCurso(Long id);
    List<Disciplina> buscarDetalhesDisciplinasPorCurso(String cursoNome);
    List<String> findCursosNaoRepetidos();
    void excluirMatrizCurricularPorCurso(String curso);
}
