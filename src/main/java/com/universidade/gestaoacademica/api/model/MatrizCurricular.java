package com.universidade.gestaoacademica.api.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
@Table(name = "MATRIZ_CURRICULAR")
public class MatrizCurricular {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message = "Curso não pode ser vazio")
    private String curso;


    @NotNull(message = "Disciplina não pode ser vazia")
    @Column(name = "DISCIPLINA_ID")
    private Integer disciplinaId;

}
