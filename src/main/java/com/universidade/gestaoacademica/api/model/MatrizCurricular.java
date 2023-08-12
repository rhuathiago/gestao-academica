package com.universidade.gestaoacademica.api.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class MatrizCurricular {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String curso;

    @OneToMany(mappedBy = "matrizCurricular")
    private List<MatrizCurricularDisciplina> disciplinas;
}
