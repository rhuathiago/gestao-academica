package com.universidade.gestaoacademica.api.service.impl;

import com.universidade.gestaoacademica.api.model.Usuario;
import com.universidade.gestaoacademica.api.repository.UsuarioRepository;
import com.universidade.gestaoacademica.api.service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class AdministradorServiceImpl implements AdministradorService {

    @Autowired
    private UsuarioRepository usuarioRepository;
//    @Autowired
//    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

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
        Usuario usuarioAtualizado = visualizarUsuario(id);

        usuarioAtualizado.setSenha(usuario.getSenha());
        usuarioAtualizado.setLogin(usuario.getLogin());
        usuarioAtualizado.setTipoDeUsuario(usuario.getTipoDeUsuario());
        usuarioAtualizado.setMatricula(usuario.getMatricula());
        usuarioAtualizado.setNome(usuario.getNome());

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

//    @Override
//    public void atualizarUsuario(Usuario usuario) {
//        String sql = "UPDATE USUARIO SET NOME = :NOME, MATRICULA = :MATRICULA, LOGIN = :LOGIN, SENHA = :SENHA, TIPO_DE_USUARIO = :TIPO_DE_USUARIO " +
//                "WHERE ID = :ID";
//
//        MapSqlParameterSource params = criarParametros(usuario);
//
//        namedParameterJdbcTemplate.update(sql, params);
//    }


//    public List<Usuario> listarUsuariosTeste() {
//        String sql = "SELECT * FROM USUARIO";
//        return namedParameterJdbcTemplate.query(sql, (resultSet, rowNum) -> {
//            Usuario usuario = new Usuario();
//            usuario.setId(resultSet.getLong("id"));
//            usuario.setLogin(resultSet.getString("login"));
//            usuario.setMatricula(resultSet.getInt("matricula"));
//            usuario.setNome(resultSet.getString("nome"));
//            usuario.setSenha(resultSet.getString("senha"));
//            usuario.setTipoDeUsuario(TipoDeUsuario.valueOf(resultSet.getString("tipo_de_usuario")));
//            return usuario;
//        });
//    }

//    public void criarUsuarioTeste(Usuario usuario) {
//
//        String sql = "INSERT INTO USUARIO (NOME, MATRICULA, LOGIN, SENHA, TIPO_DE_USUARIO) " +
//                "VALUES (:NOME, :MATRICULA, :LOGIN, :SENHA, :TIPO_DE_USUARIO)";
//
//        MapSqlParameterSource params = criarParametros(usuario);
//
//        namedParameterJdbcTemplate.update(sql, params);
//    }
//
//    private MapSqlParameterSource criarParametros(Usuario usuario) {
//        return new MapSqlParameterSource()
//                .addValue("NOME", usuario.getNome())
//                .addValue("MATRICULA", usuario.getMatricula())
//                .addValue("LOGIN", usuario.getLogin())
//                .addValue("SENHA", usuario.getSenha())
//                .addValue("TIPO_DE_USUARIO", usuario.getTipoDeUsuario());
//    }

}
