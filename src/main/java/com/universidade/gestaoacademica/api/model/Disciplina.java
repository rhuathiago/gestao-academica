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
@Table(name = "DISCIPLINA")
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome não pode ser vazio")
    private String nome;

    @NotNull(message = "Semestre não pode ser vazio")
    private Integer semestre;

    @NotNull(message = "Horas não pode ser vazia")
    private Integer horas;

}
