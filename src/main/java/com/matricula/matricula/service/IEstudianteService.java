package com.matricula.matricula.service;

import java.util.List;

import com.matricula.matricula.model.Estudiante;
import com.matricula.matricula.service.generic.ICrud;

public interface IEstudianteService extends ICrud<Estudiante, Integer> {
    List<Estudiante> sortedEdad();
}
