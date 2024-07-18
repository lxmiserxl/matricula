package com.matricula.matricula.service.impl;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.matricula.matricula.model.Matricula;
import com.matricula.matricula.repo.IMatriculaRepo;
import com.matricula.matricula.repo.generic.IGenericRepo;
import com.matricula.matricula.service.IMatriculaService;
import com.matricula.matricula.service.generic.impl.CrudImpl;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MatriculaServiceImpl extends CrudImpl<Matricula, Integer> implements IMatriculaService {

    private final IMatriculaRepo repo;

    @Override
    protected IGenericRepo<Matricula, Integer> getRepo() {
        return repo;
    }

    @Override
    public Map<String, List<String>> findCursosEstudiantes() {
        Map<String, List<String>> cursoEstudiantesMap = repo.findAll()
                .stream()
                .flatMap(matricula -> matricula.getMatriculaDetalle()
                        .stream()
                        .map(detalle -> {
                            String curso = detalle.getCurso().getNombre();
                            String estudiante = matricula.getEstudiante().getNombres();
                            return new AbstractMap.SimpleImmutableEntry<>(curso, estudiante);
                        }))
                .collect(Collectors.groupingBy(m -> m.getKey(),
                        Collectors.mapping(m -> m.getValue(), Collectors.toList())));
        return cursoEstudiantesMap;
    }

}
