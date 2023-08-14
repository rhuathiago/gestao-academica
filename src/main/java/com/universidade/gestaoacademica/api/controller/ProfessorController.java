package com.universidade.gestaoacademica.api.controller;

import com.universidade.gestaoacademica.api.model.MatrizCurricular;
import com.universidade.gestaoacademica.api.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    private final ProfessorService professorService;

    @Autowired
    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping("/visualizar-matriz-curricular/{id}")
    public ResponseEntity<MatrizCurricular> visualizarMatrizCurricular(@PathVariable Long id) {
        MatrizCurricular matrizCurricular = professorService.visualizarMatrizCurricular(id);
        if (matrizCurricular != null) {
            return new ResponseEntity<>(matrizCurricular, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
