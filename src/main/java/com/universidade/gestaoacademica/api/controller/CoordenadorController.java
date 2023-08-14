package com.universidade.gestaoacademica.api.controller;

import com.universidade.gestaoacademica.api.model.Disciplina;
import com.universidade.gestaoacademica.api.model.MatrizCurricular;
import com.universidade.gestaoacademica.api.service.CoordenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coordenador")
public class CoordenadorController {

    private final CoordenadorService coordenadorService;

    @Autowired
    public CoordenadorController(CoordenadorService coordenadorService) {
        this.coordenadorService = coordenadorService;
    }

    @PostMapping("/criar-disciplina")
    public ResponseEntity<Disciplina> criarDisciplina(@RequestBody Disciplina disciplina) {
        Disciplina novaDisciplina = coordenadorService.criarDisciplina(disciplina);
        return new ResponseEntity<>(novaDisciplina, HttpStatus.CREATED);
    }

    @GetMapping("/listar-disciplinas")
    public ResponseEntity<List<Disciplina>> listarDisciplinas() {
        List<Disciplina> disciplinas = coordenadorService.listarDisciplinas();
        return new ResponseEntity<>(disciplinas, HttpStatus.OK);
    }

    @PutMapping("/disciplina/{id}")
    public ResponseEntity<Disciplina> atualizarDisciplina(@PathVariable Long id, @RequestBody Disciplina disciplina) {
        Disciplina disciplinaAtualizada = coordenadorService.atualizarDisciplina(id, disciplina);
        if (disciplinaAtualizada != null) {
            return new ResponseEntity<>(disciplinaAtualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/disciplina/{id}")
    public ResponseEntity<Void> excluirDisciplina(@PathVariable Long id) {
        coordenadorService.excluirDisciplina(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/disciplina/{id}")
    public ResponseEntity<Disciplina> visualizarDisciplina(@PathVariable Long id) {
        Disciplina disciplina = coordenadorService.visualizarDisciplina(id);
        if (disciplina != null) {
            return new ResponseEntity<>(disciplina, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/criar-matriz-curricular")
    public ResponseEntity<MatrizCurricular> criarMatrizCurricular(@RequestBody MatrizCurricular matrizCurricular) {
        MatrizCurricular novaMatrizCurricular = coordenadorService.criarMatrizCurricular(matrizCurricular);
        return new ResponseEntity<>(novaMatrizCurricular, HttpStatus.CREATED);
    }

    @GetMapping("/listar-matrizes-curriculares")
    public ResponseEntity<List<MatrizCurricular>> listarMatrizesCurriculares() {
        List<MatrizCurricular> matrizesCurriculares = coordenadorService.listarMatrizesCurriculares();
        return new ResponseEntity<>(matrizesCurriculares, HttpStatus.OK);
    }

    @PutMapping("/matriz-curricular/{id}")
    public ResponseEntity<MatrizCurricular> atualizarMatrizCurricular(@PathVariable Long id,
                                                                      @RequestBody MatrizCurricular matrizCurricular) {
        MatrizCurricular matrizCurricularAtualizada = coordenadorService.atualizarMatrizCurricular(id, matrizCurricular);
        if (matrizCurricularAtualizada != null) {
            return new ResponseEntity<>(matrizCurricularAtualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/matriz-curricular/{id}")
    public ResponseEntity<Void> excluirMatrizCurricular(@PathVariable Long id) {
        coordenadorService.excluirMatrizCurricular(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/matriz-curricular/{id}")
    public ResponseEntity<MatrizCurricular> visualizarMatrizCurricular(@PathVariable Long id) {
        MatrizCurricular matrizCurricular = coordenadorService.visualizarMatrizCurricular(id);
        if (matrizCurricular != null) {
            return new ResponseEntity<>(matrizCurricular, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
