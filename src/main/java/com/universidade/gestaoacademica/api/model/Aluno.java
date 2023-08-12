package com.universidade.gestaoacademica.api.model;

import com.universidade.gestaoacademica.api.model.enums.TipoDeUsuario;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String matricula;
    private String curso;
    private TipoDeUsuario tipoDeUsuario;

    @ManyToOne
    private MatrizCurricular matrizCurricular;

    @PrePersist
    public void prePersist() {
        this.tipoDeUsuario = TipoDeUsuario.ALUNO;
    }

}
