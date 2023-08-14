package com.universidade.gestaoacademica.api.model;

import com.universidade.gestaoacademica.api.model.enums.TipoDeUsuario;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "professor")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message = "Nome não pode ser vazio")
    private String nome;

    @NotBlank(message = "Matrícula não pode ser vazia")
    private Integer matricula;


    @NotBlank(message = "Tipo de usuário não pode ser vazio")
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_de_usuario", columnDefinition = "VARCHAR(255)")
    private TipoDeUsuario tipoDeUsuario;

    @ManyToOne
    private MatrizCurricular matrizCurricular;

}
