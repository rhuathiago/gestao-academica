package com.universidade.gestaoacademica.api.service.impl;

import com.universidade.gestaoacademica.api.model.*;
import com.universidade.gestaoacademica.api.model.enums.TipoDeUsuario;
import com.universidade.gestaoacademica.api.repository.*;
import com.universidade.gestaoacademica.api.service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Random;

@Service
public class AdministradorServiceImpl implements AdministradorService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private CoordenadorRepository coordenadorRepository;

    @Autowired
    private AdministradorRepository administradorRepository;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public Usuario criarUsuario(Usuario usuario) {
        if (usuarioRepository.existsByLogin(usuario.getLogin())) {
            throw new IllegalArgumentException("Já existe um usuário com este login.");
        }

        usuario.setMatricula(gerarMatriculaUnica());

        criarNovoUsuario(usuario.getTipoDeUsuario(), usuario);

        String senhaCriptografada = passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(senhaCriptografada);

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

    private void criarNovoUsuario(TipoDeUsuario tipoDeUsuario, Usuario usuario) {
        if (TipoDeUsuario.ALUNO == tipoDeUsuario) {
            Aluno novoAluno = new Aluno();
            novoAluno.setNome(usuario.getNome());
            novoAluno.setMatricula(usuario.getMatricula());
            novoAluno.setTipoDeUsuario(usuario.getTipoDeUsuario());
            novoAluno.setCurso(usuario.getCurso());

            alunoRepository.save(novoAluno);
        } else if (TipoDeUsuario.PROFESSOR == tipoDeUsuario) {
            Professor novoProfessor = new Professor();
            novoProfessor.setNome(usuario.getNome());
            novoProfessor.setMatricula(usuario.getMatricula());
            novoProfessor.setTipoDeUsuario(usuario.getTipoDeUsuario());
            novoProfessor.setCurso(usuario.getCurso());

            professorRepository.save(novoProfessor);
        } else if (TipoDeUsuario.COORDENADOR == tipoDeUsuario) {
            Coordenador novoCoordenador = new Coordenador();
            novoCoordenador.setNome(usuario.getNome());
            novoCoordenador.setMatricula(usuario.getMatricula());
            novoCoordenador.setTipoDeUsuario(usuario.getTipoDeUsuario());

            coordenadorRepository.save(novoCoordenador);
        } else if (TipoDeUsuario.ADMINISTRADOR == tipoDeUsuario) {
            Administrador novoAdministrador = new Administrador();
            novoAdministrador.setNome(usuario.getNome());
            novoAdministrador.setMatricula(usuario.getMatricula());
            novoAdministrador.setTipoDeUsuario(usuario.getTipoDeUsuario());

            administradorRepository.save(novoAdministrador);
        } else {
            throw new IllegalArgumentException("Tipo de usuário inválido: " + tipoDeUsuario);
        }
    }


}
