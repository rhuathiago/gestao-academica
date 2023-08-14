package com.universidade.gestaoacademica.api.util;

import com.universidade.gestaoacademica.api.model.Disciplina;
import com.universidade.gestaoacademica.api.model.MatrizCurricular;
import com.universidade.gestaoacademica.api.model.Usuario;
import com.universidade.gestaoacademica.api.model.enums.TipoDeUsuario;

public class UtilMockado {

    public Usuario getUsuarioMockado() {
        return Usuario.builder()
                .id(1L)
                .login("usuario123")
                .matricula(123456)
                .nome("Thiago")
                .senha("senha123")
                .tipoDeUsuario(TipoDeUsuario.ALUNO)
                .build();
    }

    public MatrizCurricular getMatrizCurricularMockada() {
        return MatrizCurricular.builder()
                .id(1L)
                .curso("Engenharia")
                .disciplinaId(1)
                .build();
    }

    public Disciplina getDisciplinaMockada() {
        return Disciplina.builder()
                .id(1L)
                .nome("Cálculo")
                .semestre(1)
                .horas(20)
                .build();
    }

}
