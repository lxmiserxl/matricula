package com.matricula.matricula.service;

import java.util.List;
import java.util.Map;

import com.matricula.matricula.model.Matricula;
import com.matricula.matricula.service.generic.ICrud;

public interface IMatriculaService extends ICrud<Matricula, Integer> {
    Map<String, List<String>> findCursosEstudiantes();
}
