package com.universidade.gestaoacademica.api.service.impl;

import com.universidade.gestaoacademica.api.model.Usuario;
import com.universidade.gestaoacademica.api.repository.UsuarioRepository;
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
import static org.mockito.Mockito.*;

@SpringBootTest
public class AdministradorServiceImplTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    private UtilMockado utilMockado;

    @InjectMocks
    private AdministradorServiceImpl administradorServiceImpl;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        utilMockado = new UtilMockado();
    }

//    @Test
//    public void testCriarUsuario() {
//        Usuario usuario = utilMockado.getUsuarioMockado();
//
//        when(usuarioRepository.save(any())).thenReturn(usuario);
//
//        Usuario resultado = administradorServiceImpl.criarUsuario(usuario);
//
//        verify(usuarioRepository, times(1)).save(usuario);
//        assertEquals(usuario, resultado);
//    }


    @Test
    public void testGerarMatriculaUnica() {
        when(usuarioRepository.existsByMatricula(anyInt())).thenReturn(false);

        Integer matricula = administradorServiceImpl.gerarMatriculaUnica();

        assertTrue(matricula >= 1000000 && matricula <= 9999999);
        verify(usuarioRepository, atLeastOnce()).existsByMatricula(matricula);
    }

    @Test
    public void testExcluirUsuario() {
        Long usuarioId = 1L;

        administradorServiceImpl.excluirUsuario(usuarioId);
        verify(usuarioRepository, times(1)).deleteById(usuarioId);
    }

    @Test
    public void testAtualizarUsuario() {
        Long id = 1L;
        Usuario usuarioExistente = utilMockado.getUsuarioMockado();
        Usuario usuarioAtualizado = utilMockado.getOutroUsuarioMockado();

        when(usuarioRepository.findById(any())).thenReturn(Optional.of(usuarioExistente));
        when(usuarioRepository.save(any())).thenReturn(usuarioExistente);

        Usuario resultado = administradorServiceImpl.atualizarUsuario(id, usuarioAtualizado);

        verify(usuarioRepository, times(1)).findById(id);
        verify(usuarioRepository, times(1)).save(usuarioExistente);
        assertEquals(usuarioAtualizado, resultado);
    }

    @Test
    public void testAtualizarUsuarioNaoExistente() {
        Long userId = 1L;

        when(usuarioRepository.findById(userId)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> {
            administradorServiceImpl.atualizarUsuario(userId, utilMockado.getUsuarioMockado());
        });

        verify(usuarioRepository, times(1)).findById(userId);
        verify(usuarioRepository, never()).save(any());
    }

    @Test
    public void testListarUsuarios() {
        List<Usuario> usuariosMockados = new ArrayList<>();
        usuariosMockados.add(utilMockado.getUsuarioMockado());
        usuariosMockados.add(utilMockado.getOutroUsuarioMockado());

        when(usuarioRepository.findAll()).thenReturn(usuariosMockados);

        List<Usuario> resultado = administradorServiceImpl.listarUsuarios();

        verify(usuarioRepository, times(1)).findAll();
        assertEquals(usuariosMockados, resultado);
    }


    @Test
    public void testVisualizarUsuarioExistente() {
        Long id = 1L;
        Usuario usuario = utilMockado.getUsuarioMockado();

        when(usuarioRepository.findById(id)).thenReturn(Optional.of(usuario));

        Usuario resultado = administradorServiceImpl.visualizarUsuario(id);

        verify(usuarioRepository, times(1)).findById(id);
        assertEquals(usuario, resultado);
    }

    @Test
    public void testVisualizarUsuarioNaoExistente() {
        Long id = 1L;

        when(usuarioRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> {
            administradorServiceImpl.visualizarUsuario(id);
        });

        verify(usuarioRepository, times(1)).findById(id);
    }

}
