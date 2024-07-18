package com.matricula.matricula.service.impl;

import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.matricula.matricula.model.Estudiante;
import com.matricula.matricula.repo.IEstudianteRepo;
import com.matricula.matricula.repo.generic.IGenericRepo;
import com.matricula.matricula.service.IEstudianteService;
import com.matricula.matricula.service.generic.impl.CrudImpl;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EstudianteServiceImpl extends CrudImpl<Estudiante, Integer> implements IEstudianteService {

    private final IEstudianteRepo repo;

    @Override
    protected IGenericRepo<Estudiante, Integer> getRepo() {
        return repo;
    }

    @Override
    public List<Estudiante> sortedEdad() {
        List<Estudiante> estudiante = repo.findAll();
        return estudiante.stream()
                .sorted(Comparator
                        .comparing(Estudiante::getEdad)
                        .reversed())
                .toList();
    }

}
