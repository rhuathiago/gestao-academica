package com.universidade.gestaoacademica.api.service.impl;

import com.universidade.gestaoacademica.api.model.Disciplina;
import com.universidade.gestaoacademica.api.model.MatrizCurricular;
import com.universidade.gestaoacademica.api.repository.DisciplinaRepository;
import com.universidade.gestaoacademica.api.repository.MatrizCurricularRepository;
import com.universidade.gestaoacademica.api.service.CoordenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoordenadorServiceImpl implements CoordenadorService {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Autowired
    private MatrizCurricularRepository matrizCurricularRepository;

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
        disciplina.setId(id);
        return disciplinaRepository.save(disciplina);
    }

    @Override
    public List<Disciplina> listarDisciplinas() {
        return disciplinaRepository.findAll();
    }

    @Override
    public Disciplina visualizarDisciplina(Long id) {
        return disciplinaRepository.findById(id).orElse(null);
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
        matrizCurricular.setId(id);
        return matrizCurricularRepository.save(matrizCurricular);
    }

    @Override
    public List<MatrizCurricular> listarMatrizesCurriculares() {
        return matrizCurricularRepository.findAll();
    }

    @Override
    public MatrizCurricular visualizarMatrizCurricular(Long id) {
        return matrizCurricularRepository.findById(id).orElse(null);
    }
}
