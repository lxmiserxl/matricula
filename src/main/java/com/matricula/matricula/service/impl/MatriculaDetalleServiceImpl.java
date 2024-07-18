package com.matricula.matricula.service.impl;

import org.springframework.stereotype.Service;

import com.matricula.matricula.model.MatriculaDetalle;
import com.matricula.matricula.model.MatriculaDetallePK;
import com.matricula.matricula.repo.IMatriculaDetalleRepo;
import com.matricula.matricula.repo.generic.IGenericRepo;
import com.matricula.matricula.service.IMatriculaDetalleService;
import com.matricula.matricula.service.generic.impl.CrudImpl;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MatriculaDetalleServiceImpl extends CrudImpl<MatriculaDetalle, MatriculaDetallePK>
        implements IMatriculaDetalleService {

    private final IMatriculaDetalleRepo repo;

    @Override
    protected IGenericRepo<MatriculaDetalle, MatriculaDetallePK> getRepo() {
        return repo;
    }

}
