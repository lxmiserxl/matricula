package com.matricula.matricula.service.impl;

import org.springframework.stereotype.Service;

import com.matricula.matricula.model.Curso;
import com.matricula.matricula.repo.ICursoRepo;
import com.matricula.matricula.repo.generic.IGenericRepo;
import com.matricula.matricula.service.ICursoService;
import com.matricula.matricula.service.generic.impl.CrudImpl;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CursoServiceImpl extends CrudImpl<Curso, Integer> implements ICursoService {

    private final ICursoRepo repo;

    @Override
    protected IGenericRepo<Curso, Integer> getRepo() {
        return repo;
    }

}
