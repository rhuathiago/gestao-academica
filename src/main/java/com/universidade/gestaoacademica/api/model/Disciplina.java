package com.universidade.gestaoacademica.api.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String semestre;

    @OneToMany(mappedBy = "disciplina")
    private List<MatrizCurricularDisciplina> matrizesCurriculares;
}
