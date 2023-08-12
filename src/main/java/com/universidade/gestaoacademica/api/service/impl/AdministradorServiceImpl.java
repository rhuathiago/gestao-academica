package com.universidade.gestaoacademica.api.service.impl;

import com.universidade.gestaoacademica.api.model.Usuario;
import com.universidade.gestaoacademica.api.repository.UsuarioRepository;
import com.universidade.gestaoacademica.api.service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdministradorServiceImpl implements AdministradorService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public AdministradorServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario criarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void excluirUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Usuario atualizarUsuario(Long id, Usuario usuario) {
        usuario.setId(id);
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario visualizarUsuario(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

}
