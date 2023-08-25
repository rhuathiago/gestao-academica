package com.universidade.gestaoacademica.api.controller;

import com.universidade.gestaoacademica.api.model.Aluno;
import com.universidade.gestaoacademica.api.model.MatrizCurricular;
import com.universidade.gestaoacademica.api.repository.AlunoRepository;
import com.universidade.gestaoacademica.api.repository.MatrizCurricularRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private MatrizCurricularRepository matrizCurricularRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping("/visualizar-matriz-curricular/{id}")
    public ResponseEntity<List<MatrizCurricular>> visualizarMatrizCurricular(@PathVariable Long id) {
        Optional<Aluno> alunoId = alunoRepository.findById(id);
        if (!alunoId.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Aluno aluno = alunoId.get();
        String cursoAluno = aluno.getCurso();

        List<MatrizCurricular> matrizesCurriculares = matrizCurricularRepository.findByCurso(cursoAluno);
        if (!matrizesCurriculares.isEmpty()) {
            return new ResponseEntity<>(matrizesCurriculares, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
