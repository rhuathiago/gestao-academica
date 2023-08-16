package com.universidade.gestaoacademica.api.model;

import com.universidade.gestaoacademica.api.model.enums.TipoDeUsuario;
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
@Table(name = "coordenador")
public class Coordenador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome não pode ser vazio")
    private String nome;

    @NotNull
    private Integer matricula;

    @NotBlank(message = "Curso coordenado não pode ser vazio")
    private String cursoCoordenado;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_de_usuario", columnDefinition = "VARCHAR(255)")
    private TipoDeUsuario tipoDeUsuario;

}
