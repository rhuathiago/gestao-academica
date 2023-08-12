package com.universidade.gestaoacademica.api.controller;

import com.universidade.gestaoacademica.api.model.Usuario;
import com.universidade.gestaoacademica.api.service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/administrador")
public class AdministradorController {

    private final AdministradorService administradorService;

    @Autowired
    public AdministradorController(AdministradorService administradorService) {
        this.administradorService = administradorService;
    }

    @PostMapping("/criar-usuario")
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario) {
        Usuario novoUsuario = administradorService.criarUsuario(usuario);
        return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
    }

    @GetMapping("/listar-usuarios")
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> usuarios = administradorService.listarUsuarios();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<Usuario> visualizarUsuario(@PathVariable Long id) {
        Usuario usuario = administradorService.visualizarUsuario(id);
        if (usuario != null) {
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/usuario/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        Usuario usuarioAtualizado = administradorService.atualizarUsuario(id, usuario);
        if (usuarioAtualizado != null) {
            return new ResponseEntity<>(usuarioAtualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<Void> excluirUsuario(@PathVariable Long id) {
        administradorService.excluirUsuario(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

