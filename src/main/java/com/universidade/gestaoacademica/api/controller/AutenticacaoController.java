package com.universidade.gestaoacademica.api.controller;

import com.universidade.gestaoacademica.api.security.DadosTokenJWT;
import com.universidade.gestaoacademica.api.security.TokenService;
import com.universidade.gestaoacademica.api.model.DadosAutenticacao;
import com.universidade.gestaoacademica.api.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dadosAutenticacao) {
        Authentication authenticationToken = new UsernamePasswordAuthenticationToken(
                dadosAutenticacao.getLogin(),
                dadosAutenticacao.getSenha()
        );
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);

        String tokenJWT = tokenService.gerarToken((Usuario) authenticate.getPrincipal());

        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }

}
