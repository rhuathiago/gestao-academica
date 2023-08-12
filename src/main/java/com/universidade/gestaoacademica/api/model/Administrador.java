package com.universidade.gestaoacademica.api.model;

import com.universidade.gestaoacademica.api.model.enums.TipoDeUsuario;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Administrador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private TipoDeUsuario tipoDeUsuario;

    @PrePersist
    public void prePersist() {
        this.tipoDeUsuario = TipoDeUsuario.ADMINISTRADOR;
    }

}
