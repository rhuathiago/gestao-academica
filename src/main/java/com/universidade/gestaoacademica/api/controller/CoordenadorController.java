package com.universidade.gestaoacademica.api.controller;

import com.universidade.gestaoacademica.api.model.Curso;
import com.universidade.gestaoacademica.api.model.Disciplina;
import com.universidade.gestaoacademica.api.model.MatrizCurricular;
import com.universidade.gestaoacademica.api.service.CoordenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coordenador")
public class CoordenadorController {

    @Autowired
    private CoordenadorService coordenadorService;

    @PreAuthorize("hasAnyAuthority('ROLE_COORDENADOR')")
    @Transactional
    @PostMapping("/criar-disciplina")
    public ResponseEntity<Disciplina> criarDisciplina(@RequestBody Disciplina disciplina) {
        Disciplina novaDisciplina = coordenadorService.criarDisciplina(disciplina);
        return new ResponseEntity<>(novaDisciplina, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_COORDENADOR')")
    @GetMapping("/listar-disciplinas")
    public ResponseEntity<List<Disciplina>> listarDisciplinas() {
        List<Disciplina> disciplinas = coordenadorService.listarDisciplinas();
        return new ResponseEntity<>(disciplinas, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_COORDENADOR')")
    @Transactional
    @PutMapping("/atualizar-disciplina/{id}")
    public ResponseEntity<Disciplina> atualizarDisciplina(@PathVariable Long id, @RequestBody Disciplina disciplina) {
        Disciplina disciplinaAtualizada = coordenadorService.atualizarDisciplina(id, disciplina);
        if (disciplinaAtualizada != null) {
            return new ResponseEntity<>(disciplinaAtualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasAnyAuthority('ROLE_COORDENADOR')")
    @Transactional
    @DeleteMapping("/excluir-disciplina/{id}")
    public ResponseEntity<Void> excluirDisciplina(@PathVariable Long id) {
        coordenadorService.excluirDisciplina(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_COORDENADOR')")
    @GetMapping("/visualizar-disciplina/{id}")
    public ResponseEntity<Disciplina> visualizarDisciplina(@PathVariable Long id) {
        Disciplina disciplina = coordenadorService.visualizarDisciplina(id);
        if (disciplina != null) {
            return new ResponseEntity<>(disciplina, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasAnyAuthority('ROLE_COORDENADOR')")
    @Transactional
    @PostMapping("/criar-matriz-curricular")
    public ResponseEntity<MatrizCurricular> criarMatrizCurricular(@RequestBody MatrizCurricular matrizCurricular) {
        MatrizCurricular novaMatrizCurricular = coordenadorService.criarMatrizCurricular(matrizCurricular);
        return new ResponseEntity<>(novaMatrizCurricular, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_COORDENADOR', 'ROLE_PROFESSOR', 'ROLE_ALUNO')")
    @GetMapping("/listar-matrizes-curriculares")
    public ResponseEntity<List<String>> listarMatrizesCurriculares() {
        List<String> matrizesCurriculares = coordenadorService.findCursosNaoRepetidos();
        return new ResponseEntity<>(matrizesCurriculares, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_COORDENADOR', 'ROLE_PROFESSOR', 'ROLE_ALUNO')")
    @GetMapping("/detalhes-disciplinas/{cursoNome}")
    public ResponseEntity<List<Disciplina>> buscarDetalhesDisciplinasPorCurso(@PathVariable String cursoNome) {
        List<Disciplina> disciplinasDetalhadas = coordenadorService.buscarDetalhesDisciplinasPorCurso(cursoNome);
        return new ResponseEntity<>(disciplinasDetalhadas, HttpStatus.OK);
    }


    @PreAuthorize("hasAnyAuthority('ROLE_COORDENADOR')")
    @Transactional
    @PutMapping("/atualizar-matriz-curricular/{id}")
    public ResponseEntity<MatrizCurricular> atualizarMatrizCurricular(@PathVariable Long id,
                                                                      @RequestBody MatrizCurricular matrizCurricular) {
        MatrizCurricular matrizCurricularAtualizada = coordenadorService.atualizarMatrizCurricular(id, matrizCurricular);
        if (matrizCurricularAtualizada != null) {
            return new ResponseEntity<>(matrizCurricularAtualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasAnyAuthority('ROLE_COORDENADOR')")
    @Transactional
    @DeleteMapping("/excluir-matriz-curricular/{curso}")
    public ResponseEntity<Void> excluirMatrizCurricularPorCurso(@PathVariable String curso) {
        coordenadorService.excluirMatrizCurricularPorCurso(curso);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_COORDENADOR', 'ROLE_PROFESSOR', 'ROLE_ALUNO')")
    @GetMapping("/visualizar-matriz-curricular/{id}")
    public ResponseEntity<MatrizCurricular> visualizarMatrizCurricular(@PathVariable Long id) {
        MatrizCurricular matrizCurricular = coordenadorService.visualizarMatrizCurricular(id);
        if (matrizCurricular != null) {
            return new ResponseEntity<>(matrizCurricular, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasAnyAuthority('ROLE_COORDENADOR')")
    @GetMapping("/listar-cursos")
    public ResponseEntity<List<Curso>> listarCursos() {
        List<Curso> cursos = coordenadorService.listarCursos();
        return new ResponseEntity<>(cursos, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_COORDENADOR')")
    @Transactional
    @PostMapping("/criar-curso")
    public ResponseEntity<Curso> criarCurso(@RequestBody Curso curso) {
        Curso novoCurso = coordenadorService.criarCurso(curso);
        return new ResponseEntity<>(novoCurso, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_COORDENADOR')")
    @Transactional
    @PutMapping("/atualizar-curso/{id}")
    public ResponseEntity<Curso> atualizarCurso(@PathVariable Long id,
                                                           @RequestBody Curso curso) {
        Curso cursoAtualizado = coordenadorService.atualizarCurso(id, curso);
        if (cursoAtualizado != null) {
            return new ResponseEntity<>(cursoAtualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasAnyAuthority('ROLE_COORDENADOR')")
    @Transactional
    @DeleteMapping("/excluir-curso/{id}")
    public ResponseEntity<Void> excluirCurso(@PathVariable Long id) {
        coordenadorService.excluirCurso(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_COORDENADOR', 'ROLE_PROFESSOR', 'ROLE_ALUNO')")
    @GetMapping("/visualizar-curso/{id}")
    public ResponseEntity<Curso> visualizarCurso(@PathVariable Long id) {
        Curso cursoId = coordenadorService.findCursoById(id);
        if (cursoId != null) {
            return new ResponseEntity<>(cursoId, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
