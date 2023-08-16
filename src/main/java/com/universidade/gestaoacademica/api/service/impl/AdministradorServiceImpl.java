package com.universidade.gestaoacademica.api.service.impl;

import com.universidade.gestaoacademica.api.model.Usuario;
import com.universidade.gestaoacademica.api.repository.UsuarioRepository;
import com.universidade.gestaoacademica.api.service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Random;

@Service
public class AdministradorServiceImpl implements AdministradorService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario criarUsuario(Usuario usuario) {
        usuario.setMatricula(gerarMatriculaUnica());
        return usuarioRepository.save(usuario);
    }

    @Override
    public void excluirUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Usuario atualizarUsuario(Long id, Usuario usuario) {
        Usuario usuarioAtualizado = visualizarUsuario(id);

        usuarioAtualizado.setLogin(usuario.getLogin());
        usuarioAtualizado.setSenha(usuario.getSenha());
        usuarioAtualizado.setNome(usuario.getNome());
        usuarioAtualizado.setTipoDeUsuario(usuario.getTipoDeUsuario());

        return usuarioRepository.save(usuarioAtualizado);
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario visualizarUsuario(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Não foi encontrado um usuário com o ID " + id));
    }

    public Integer gerarMatriculaUnica() {
        Random random = new Random();
        Integer numeroMinimo = 1000000;
        Integer numeroMaximo = 9999999;

        while (true) {
            Integer matriculaAleatoria = random.nextInt(numeroMaximo - numeroMinimo + 1) + numeroMinimo;
            if (!usuarioRepository.existsByMatricula(matriculaAleatoria)) {
                return matriculaAleatoria;
            }
        }
    }

}
