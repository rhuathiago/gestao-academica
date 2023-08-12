package com.universidade.gestaoacademica.api.model;

import com.universidade.gestaoacademica.api.model.enums.TipoDeUsuario;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String login;
    private String senha;
    private TipoDeUsuario tipoDeUsuario;

}
