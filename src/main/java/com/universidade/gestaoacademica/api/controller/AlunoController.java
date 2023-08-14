package com.universidade.gestaoacademica.api.controller;

import com.universidade.gestaoacademica.api.model.MatrizCurricular;
import com.universidade.gestaoacademica.api.service.AlunoService;
import com.universidade.gestaoacademica.api.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    private final AlunoService alunoService;

    @Autowired
    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping("/visualizar-matriz-curricular/{id}")
    public ResponseEntity<MatrizCurricular> visualizarMatrizCurricular(@PathVariable Long id) {
        MatrizCurricular matrizCurricular = alunoService.visualizarMatrizCurricular(id);
        if (matrizCurricular != null) {
            return new ResponseEntity<>(matrizCurricular, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
