package com.universidade.gestaoacademica.api.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class MatrizCurricularDisciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private MatrizCurricular matrizCurricular;

    @ManyToOne
    private Disciplina disciplina;
}
