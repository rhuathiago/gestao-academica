package com.universidade.gestaoacademica.api.service.impl;

import com.universidade.gestaoacademica.api.model.Curso;
import com.universidade.gestaoacademica.api.model.Disciplina;
import com.universidade.gestaoacademica.api.model.MatrizCurricular;
import com.universidade.gestaoacademica.api.repository.CursoRepository;
import com.universidade.gestaoacademica.api.repository.DisciplinaRepository;
import com.universidade.gestaoacademica.api.repository.MatrizCurricularRepository;
import com.universidade.gestaoacademica.api.service.CoordenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CoordenadorServiceImpl implements CoordenadorService {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Autowired
    private MatrizCurricularRepository matrizCurricularRepository;
    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public Disciplina criarDisciplina(Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }

    @Override
    public void excluirDisciplina(Long id) {
        disciplinaRepository.deleteById(id);
    }

    @Override
    public Disciplina atualizarDisciplina(Long id, Disciplina disciplina) {
        Disciplina disciplinaAtualizada = visualizarDisciplina(id);

        disciplinaAtualizada.setNome(disciplina.getNome());
        disciplinaAtualizada.setSemestre(disciplina.getSemestre());
        disciplinaAtualizada.setHoras(disciplina.getHoras());

        return disciplinaRepository.save(disciplinaAtualizada);
    }

    @Override
    public List<Disciplina> listarDisciplinas() {
        return disciplinaRepository.findAll();
    }

    @Override
    public Disciplina visualizarDisciplina(Long id) {
        return disciplinaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Não foi encontrada uma disciplina com o ID" + id));
    }

    @Override
    public MatrizCurricular criarMatrizCurricular(MatrizCurricular matrizCurricular) {
        return matrizCurricularRepository.save(matrizCurricular);
    }

    @Override
    public void excluirMatrizCurricular(Long id) {
        matrizCurricularRepository.deleteById(id);
    }

    @Override
    public MatrizCurricular atualizarMatrizCurricular(Long id, MatrizCurricular matrizCurricular) {
        MatrizCurricular matrizCurricularAtualizada = visualizarMatrizCurricular(id);

        matrizCurricularAtualizada.setCurso(matrizCurricular.getCurso());
        matrizCurricularAtualizada.setDisciplinaId(matrizCurricular.getDisciplinaId());

        return matrizCurricularRepository.save(matrizCurricularAtualizada);
    }

    @Override
    public List<MatrizCurricular> listarMatrizesCurriculares() {
        return matrizCurricularRepository.findAll();
    }

    @Override
    public MatrizCurricular visualizarMatrizCurricular(Long id) {
        return matrizCurricularRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Não foi encontrada uma matriz curricular com o ID" + id));
    }

    @Override
    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }

    @Override
    public Curso criarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public Curso atualizarCurso(Long id, Curso curso) {
        Curso cursoAtualizado = findCursoById(id);

        cursoAtualizado.setNome(curso.getNome());

        return cursoRepository.save(cursoAtualizado);
    }

    @Override
    public Curso findCursoById(Long id) {
        return cursoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Não foi encontrada um curso com o ID" + id));
    }

    @Override
    public void excluirCurso(Long id) {
        cursoRepository.deleteById(id);
    }

    @Override
    public List<Disciplina> buscarDetalhesDisciplinasPorCurso(String cursoNome) {
        return matrizCurricularRepository.findDisciplinasByCursoNome(cursoNome);
    }

    @Override
    public List<String> findCursosNaoRepetidos() {
        return matrizCurricularRepository.findCursosNaoRepetidos();
    }

    @Override
    public void excluirMatrizCurricularPorCurso(String curso) {
        matrizCurricularRepository.deleteByCurso(curso);
    }

}
