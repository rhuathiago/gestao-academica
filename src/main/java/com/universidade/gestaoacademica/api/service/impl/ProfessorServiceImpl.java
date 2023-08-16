package com.universidade.gestaoacademica.api.service.impl;

import com.universidade.gestaoacademica.api.model.MatrizCurricular;
import com.universidade.gestaoacademica.api.repository.MatrizCurricularRepository;
import com.universidade.gestaoacademica.api.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    private MatrizCurricularRepository matrizCurricularRepository;

    @Override
    public MatrizCurricular visualizarMatrizCurricular(Long id) {
        return matrizCurricularRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Não foi encontrado uma matriz curricular com o ID" + id));
    }

}
