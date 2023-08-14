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
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

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

    @Mock
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private UtilMockado utilMockado;

    @InjectMocks
    private AdministradorServiceImpl administradorServiceImpl;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        utilMockado = new UtilMockado();
    }

    @Test
    public void testCriarUsuario() {

        Usuario usuario = utilMockado.getUsuarioMockado();
        when(usuarioRepository.save(any())).thenReturn(usuario);

        Usuario resultado = administradorServiceImpl.criarUsuario(usuario);

//        verify(usuarioRepository, times(1)).save(usuario);
        assertEquals(usuario, resultado);

    }

    @Test
    public void testExcluirUsuario() {
        Long userIdToDelete = 1L;

        administradorServiceImpl.excluirUsuario(userIdToDelete);

//        verify(usuarioRepository, times(1)).deleteById(userIdToDelete);
    }

    @Test
    public void testAtualizarUsuarioExistente() {
        Long userId = 1L;

        Usuario usuarioExistente = utilMockado.getUsuarioMockado();
        usuarioExistente.setId(userId);

        Usuario usuarioAtualizado = utilMockado.getUsuarioMockado();
        usuarioAtualizado.setId(userId);
        usuarioAtualizado.setNome("Novo Nome");

        when(usuarioRepository.findById(userId)).thenReturn(Optional.of(usuarioExistente));
        when(usuarioRepository.save(usuarioAtualizado)).thenReturn(usuarioAtualizado);

        Usuario resultado = administradorServiceImpl.atualizarUsuario(userId, usuarioAtualizado);

//        verify(usuarioRepository, times(1)).findById(userId);
//        verify(usuarioRepository, times(1)).save(usuarioAtualizado);
        assertEquals(usuarioAtualizado, resultado);
    }

    @Test
    public void testAtualizarUsuarioNaoExistente() {
        Long userId = 1L;

        when(usuarioRepository.findById(userId)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> {
            administradorServiceImpl.atualizarUsuario(userId, utilMockado.getUsuarioMockado());
        });

//        verify(usuarioRepository, times(1)).findById(userId);
//        verify(usuarioRepository, never()).save(any());
    }

    @Test
    public void testListarUsuarios() {
        List<Usuario> usuariosDoRepositorio = new ArrayList<>();
        usuariosDoRepositorio.add(utilMockado.getUsuarioMockado());
        usuariosDoRepositorio.add(utilMockado.getUsuarioMockado());

        when(usuarioRepository.findAll()).thenReturn(usuariosDoRepositorio);

        List<Usuario> resultado = administradorServiceImpl.listarUsuarios();

//        verify(usuarioRepository, times(1)).findAll();
        assertEquals(usuariosDoRepositorio, resultado);
    }

    @Test
    public void testVisualizarUsuarioExistente() {
        Long userId = 1L;

        Usuario usuarioExistente = utilMockado.getUsuarioMockado();
        usuarioExistente.setId(userId);

        when(usuarioRepository.findById(userId)).thenReturn(Optional.of(usuarioExistente));

        Usuario resultado = administradorServiceImpl.visualizarUsuario(userId);

//        verify(usuarioRepository, times(1)).findById(userId);
        assertEquals(usuarioExistente, resultado);
    }

    @Test
    public void testVisualizarUsuarioNaoExistente() {
        Long userId = 1L;

        when(usuarioRepository.findById(userId)).thenReturn(Optional.empty());

        Usuario resultado = administradorServiceImpl.visualizarUsuario(userId);

//        verify(usuarioRepository, times(1)).findById(userId);
        assertNull(resultado);
    }


}
