package com.universidade.gestaoacademica.api.service.impl;

import com.universidade.gestaoacademica.api.model.Disciplina;
import com.universidade.gestaoacademica.api.model.MatrizCurricular;
import com.universidade.gestaoacademica.api.repository.DisciplinaRepository;
import com.universidade.gestaoacademica.api.repository.MatrizCurricularRepository;
import com.universidade.gestaoacademica.api.util.UtilMockado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class CoordenadorServiceImplTest {

    @Mock
    private DisciplinaRepository disciplinaRepository;

    @Mock
    private MatrizCurricularRepository matrizCurricularRepository;

    private UtilMockado utilMockado;

    @InjectMocks
    private CoordenadorServiceImpl coordenadorServiceImpl;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        utilMockado = new UtilMockado();
    }

    @Test
    public void testCriarDisciplina() {
        Disciplina disciplina = utilMockado.getDisciplinaMockada();
        when(disciplinaRepository.save(any())).thenReturn(disciplina);

        Disciplina resultado = coordenadorServiceImpl.criarDisciplina(disciplina);

        assertEquals(disciplina, resultado);
    }

    @Test
    public void testExcluirDisciplina() {
        Long disciplinaId = 1L;

        coordenadorServiceImpl.excluirDisciplina(disciplinaId);

        verify(disciplinaRepository, times(1)).deleteById(disciplinaId);
    }

    @Test
    public void testAtualizarDisciplina() {
        Long disciplinaId = 1L;
        Disciplina disciplinaAtualizada = utilMockado.getDisciplinaMockada();
        disciplinaAtualizada.setId(disciplinaId);

        when(disciplinaRepository.save(disciplinaAtualizada)).thenReturn(disciplinaAtualizada);

        Disciplina resultado = coordenadorServiceImpl.atualizarDisciplina(disciplinaId, disciplinaAtualizada);

        assertEquals(disciplinaAtualizada, resultado);
    }

    @Test
    public void testListarDisciplinas() {
        List<Disciplina> disciplinasMockadas = new ArrayList<>();
        disciplinasMockadas.add(utilMockado.getDisciplinaMockada());
        disciplinasMockadas.add(utilMockado.getDisciplinaMockada());

        when(disciplinaRepository.findAll()).thenReturn(disciplinasMockadas);

        List<Disciplina> resultado = coordenadorServiceImpl.listarDisciplinas();

        // Verificação
//        verify(disciplinaRepository, times(1)).findAll();
        assertEquals(disciplinasMockadas, resultado);
    }

    @Test
    public void testVisualizarDisciplinaExistente() {
        Long disciplinaId = 1L;

        Disciplina disciplinaExistente = utilMockado.getDisciplinaMockada();
        disciplinaExistente.setId(disciplinaId);

        when(disciplinaRepository.findById(disciplinaId)).thenReturn(Optional.of(disciplinaExistente));

        Disciplina resultado = coordenadorServiceImpl.visualizarDisciplina(disciplinaId);

//        verify(disciplinaRepository, times(1)).findById(disciplinaId);
        assertEquals(disciplinaExistente, resultado);
    }

    @Test
    public void testVisualizarDisciplinaNaoExistente() {
        Long disciplinaId = 1L;

        when(disciplinaRepository.findById(disciplinaId)).thenReturn(Optional.empty());

        Disciplina resultado = coordenadorServiceImpl.visualizarDisciplina(disciplinaId);

//        verify(disciplinaRepository, times(1)).findById(disciplinaId);
        assertNull(resultado);
    }

    @Test
    public void testCriarMatrizCurricular() {
        MatrizCurricular matrizCurricular = utilMockado.getMatrizCurricularMockada();

        when(matrizCurricularRepository.save(matrizCurricular)).thenReturn(matrizCurricular);

        MatrizCurricular resultado = coordenadorServiceImpl.criarMatrizCurricular(matrizCurricular);

//        verify(matrizCurricularRepository, times(1)).save(matrizCurricular);
        assertEquals(matrizCurricular, resultado);
    }

    @Test
    public void testExcluirMatrizCurricular() {
        Long matrizCurricularId = 1L;

        assertDoesNotThrow(() -> coordenadorServiceImpl.excluirMatrizCurricular(matrizCurricularId));

//        verify(matrizCurricularRepository, times(1)).deleteById(matrizCurricularId);
    }

    @Test
    public void testAtualizarMatrizCurricular() {
        Long matrizCurricularId = 1L;
        MatrizCurricular matrizCurricularAtualizada = utilMockado.getMatrizCurricularMockada();
        matrizCurricularAtualizada.setId(matrizCurricularId);

        when(matrizCurricularRepository.save(matrizCurricularAtualizada)).thenReturn(matrizCurricularAtualizada);

        MatrizCurricular resultado = coordenadorServiceImpl.atualizarMatrizCurricular(matrizCurricularId, matrizCurricularAtualizada);

//        verify(matrizCurricularRepository, times(1)).save(matrizCurricularAtualizada);
        assertEquals(matrizCurricularAtualizada, resultado);
    }

    @Test
    public void testListarMatrizesCurriculares() {
        List<MatrizCurricular> matrizesMockadas = new ArrayList<>();
        matrizesMockadas.add(utilMockado.getMatrizCurricularMockada());
        matrizesMockadas.add(utilMockado.getMatrizCurricularMockada());

        when(matrizCurricularRepository.findAll()).thenReturn(matrizesMockadas);

        List<MatrizCurricular> resultado = coordenadorServiceImpl.listarMatrizesCurriculares();

//        verify(matrizCurricularRepository, times(1)).findAll();
        assertEquals(matrizesMockadas, resultado);
    }

    @Test
    public void testVisualizarMatrizCurricularExistente() {
        Long matrizCurricularId = 1L;

        MatrizCurricular matrizCurricularExistente = utilMockado.getMatrizCurricularMockada();
        matrizCurricularExistente.setId(matrizCurricularId);

        when(matrizCurricularRepository.findById(matrizCurricularId)).thenReturn(Optional.of(matrizCurricularExistente));

        MatrizCurricular resultado = coordenadorServiceImpl.visualizarMatrizCurricular(matrizCurricularId);

//        verify(matrizCurricularRepository, times(1)).findById(matrizCurricularId);
        assertEquals(matrizCurricularExistente, resultado);
    }

    @Test
    public void testVisualizarMatrizCurricularNaoExistente() {
        Long matrizCurricularId = 1L;

        when(matrizCurricularRepository.findById(matrizCurricularId)).thenReturn(Optional.empty());

        MatrizCurricular resultado = coordenadorServiceImpl.visualizarMatrizCurricular(matrizCurricularId);

//        verify(matrizCurricularRepository, times(1)).findById(matrizCurricularId);
        assertNull(resultado);
    }


}
