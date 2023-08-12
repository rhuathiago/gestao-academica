package com.universidade.gestaoacademica.api.model;

import com.universidade.gestaoacademica.api.model.enums.TipoDeUsuario;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Coordenador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cursoCoordenado;
    private TipoDeUsuario tipoDeUsuario;

    @PrePersist
    public void prePersist() {
        this.tipoDeUsuario = TipoDeUsuario.COORDENADOR;
    }

}
