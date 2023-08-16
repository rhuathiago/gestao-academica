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

import javax.persistence.EntityNotFoundException;
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
        Long id = 1L;
        Disciplina disciplinaExistente = utilMockado.getDisciplinaMockada();
        Disciplina disciplinaAtualizada = utilMockado.getOutraDisciplinaMockada();

        when(disciplinaRepository.findById(any())).thenReturn(Optional.of(disciplinaExistente));
        when(disciplinaRepository.save(any())).thenReturn(disciplinaExistente);

        Disciplina resultado = coordenadorServiceImpl.atualizarDisciplina(id, disciplinaAtualizada);

        verify(disciplinaRepository, times(1)).findById(id);
        verify(disciplinaRepository, times(1)).save(disciplinaExistente);
        assertEquals(disciplinaAtualizada, resultado);
    }

    @Test
    public void testAtualizarDisciplinaNaoExistente() {
        Long userId = 1L;

        when(disciplinaRepository.findById(userId)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> {
            coordenadorServiceImpl.atualizarDisciplina(userId, utilMockado.getDisciplinaMockada());
        });

        verify(disciplinaRepository, times(1)).findById(userId);
        verify(disciplinaRepository, never()).save(any());
    }

    @Test
    public void testListarDisciplinas() {
        List<Disciplina> disciplinasMockadas = new ArrayList<>();
        disciplinasMockadas.add(utilMockado.getDisciplinaMockada());
        disciplinasMockadas.add(utilMockado.getOutraDisciplinaMockada());

        when(disciplinaRepository.findAll()).thenReturn(disciplinasMockadas);

        List<Disciplina> resultado = coordenadorServiceImpl.listarDisciplinas();

        verify(disciplinaRepository, times(1)).findAll();
        assertEquals(disciplinasMockadas, resultado);
    }

    @Test
    public void testVisualizarDisciplinaExistente() {
        Long id = 1L;
        Disciplina disciplina = utilMockado.getDisciplinaMockada();

        when(disciplinaRepository.findById(id)).thenReturn(Optional.of(disciplina));

        Disciplina resultado = coordenadorServiceImpl.visualizarDisciplina(id);

        verify(disciplinaRepository, times(1)).findById(id);
        assertEquals(disciplina, resultado);
    }

    @Test
    public void testVisualizarDisciplinaNaoExistente() {
        Long id = 1L;

        when(disciplinaRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> {
            coordenadorServiceImpl.visualizarDisciplina(id);
        });

        verify(disciplinaRepository, times(1)).findById(id);
    }

    @Test
    public void testCriarMatrizCurricular() {
        MatrizCurricular matrizCurricular = utilMockado.getMatrizCurricularMockada();

        when(matrizCurricularRepository.save(matrizCurricular)).thenReturn(matrizCurricular);

        MatrizCurricular resultado = coordenadorServiceImpl.criarMatrizCurricular(matrizCurricular);

        verify(matrizCurricularRepository, times(1)).save(matrizCurricular);
        assertEquals(matrizCurricular, resultado);
    }

    @Test
    public void testExcluirMatrizCurricular() {
        Long matrizCurricularId = 1L;

        assertDoesNotThrow(() -> coordenadorServiceImpl.excluirMatrizCurricular(matrizCurricularId));

        verify(matrizCurricularRepository, times(1)).deleteById(matrizCurricularId);
    }

    @Test
    public void testAtualizarMatrizCurricular() {
        Long id = 1L;
        MatrizCurricular matrizCurricularExistente = utilMockado.getMatrizCurricularMockada();
        MatrizCurricular matrizCurricularAtualizada = utilMockado.getOutraMatrizCurricularMockada();

        when(matrizCurricularRepository.findById(any())).thenReturn(Optional.of(matrizCurricularExistente));
        when(matrizCurricularRepository.save(any())).thenReturn(matrizCurricularExistente);

        MatrizCurricular resultado = coordenadorServiceImpl.atualizarMatrizCurricular(id, matrizCurricularAtualizada);

        verify(matrizCurricularRepository, times(1)).findById(id);
        verify(matrizCurricularRepository, times(1)).save(matrizCurricularExistente);
        assertEquals(matrizCurricularAtualizada, resultado);
    }

    @Test
    public void testAtualizarMatrizCurricularNaoExistente() {
        Long userId = 1L;

        when(matrizCurricularRepository.findById(userId)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> {
            coordenadorServiceImpl.atualizarMatrizCurricular(userId, utilMockado.getMatrizCurricularMockada());
        });

        verify(matrizCurricularRepository, times(1)).findById(userId);
        verify(matrizCurricularRepository, never()).save(any());
    }

    @Test
    public void testListarMatrizesCurriculares() {
        List<MatrizCurricular> matrizesMockadas = new ArrayList<>();
        matrizesMockadas.add(utilMockado.getMatrizCurricularMockada());
        matrizesMockadas.add(utilMockado.getOutraMatrizCurricularMockada());

        when(matrizCurricularRepository.findAll()).thenReturn(matrizesMockadas);

        List<MatrizCurricular> resultado = coordenadorServiceImpl.listarMatrizesCurriculares();

        verify(matrizCurricularRepository, times(1)).findAll();
        assertEquals(matrizesMockadas, resultado);
    }

    @Test
    public void testVisualizarMatrizCurricularExistente() {
        Long id = 1L;
        MatrizCurricular matrizCurricular = utilMockado.getMatrizCurricularMockada();

        when(matrizCurricularRepository.findById(id)).thenReturn(Optional.of(matrizCurricular));

        MatrizCurricular resultado = coordenadorServiceImpl.visualizarMatrizCurricular(id);

        verify(matrizCurricularRepository, times(1)).findById(id);
        assertEquals(matrizCurricular, resultado);
    }

    @Test
    public void testVisualizarMatrizCurricularaNaoExistente() {
        Long id = 1L;

        when(matrizCurricularRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> {
            coordenadorServiceImpl.visualizarMatrizCurricular(id);
        });

        verify(matrizCurricularRepository, times(1)).findById(id);
    }

}
