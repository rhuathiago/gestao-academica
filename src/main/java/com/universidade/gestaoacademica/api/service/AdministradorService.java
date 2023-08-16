package com.universidade.gestaoacademica.api.service;

import com.universidade.gestaoacademica.api.model.Usuario;

import java.util.List;

public interface AdministradorService {

    Usuario criarUsuario(Usuario usuario);

    void excluirUsuario(Long id);

    Usuario atualizarUsuario(Long id, Usuario usuario);

    List<Usuario> listarUsuarios();

    Usuario visualizarUsuario(Long id);

}

