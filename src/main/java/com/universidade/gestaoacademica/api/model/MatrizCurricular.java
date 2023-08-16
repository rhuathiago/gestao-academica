package com.universidade.gestaoacademica.api.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
@Table(name = "matriz_curricular")
public class MatrizCurricular {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message = "Curso não pode ser vazio")
    private String curso;


    @NotBlank(message = "Disciplina não pode ser vazia")
    @Column(name = "disciplina_id")
    private Integer disciplinaId;

}
