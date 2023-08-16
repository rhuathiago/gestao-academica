package com.universidade.gestaoacademica.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DadosAutenticacao {
    private String login;
    private String senha;
}
