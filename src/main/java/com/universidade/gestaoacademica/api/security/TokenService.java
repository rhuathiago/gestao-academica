package com.universidade.gestaoacademica.api.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.universidade.gestaoacademica.api.model.Aluno;
import com.universidade.gestaoacademica.api.model.Professor;
import com.universidade.gestaoacademica.api.model.Usuario;
import com.universidade.gestaoacademica.api.repository.AlunoRepository;
import com.universidade.gestaoacademica.api.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    public String gerarToken(Usuario usuario) {
        try {
            Algorithm algoritmo = Algorithm.HMAC256(secret);
            Aluno aluno = alunoRepository.findByMatricula(usuario.getMatricula());
            Professor professor = professorRepository.findByMatricula(usuario.getMatricula());

            JWTCreator.Builder jwtBuilder = JWT.create()
                    .withIssuer("API Gestão Acadêmica")
                    .withSubject(usuario.getLogin())
                    .withExpiresAt(Date.from(dataExpiracao()))
                    .withArrayClaim("roles", usuario.getAuthorities().stream()
                            .map(GrantedAuthority::getAuthority).toArray(String[]::new));

            if (aluno != null) {
                jwtBuilder = jwtBuilder.withClaim("curso", aluno.getCurso());
            } else if (professor != null) {
                jwtBuilder = jwtBuilder.withClaim("curso", professor.getCurso());
            }
            return jwtBuilder.sign(algoritmo);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Erro ao gerar Token JWT", exception);
        }
    }




    public String getSubject(String tokenJWT) {
        try {
            Algorithm algoritmo = Algorithm.HMAC256(secret);
            return JWT.require(algoritmo)
                    .withIssuer("API Gestão Acadêmica")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();

        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Token JWT inválido ou expirado!");
        }

    }

    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

}
