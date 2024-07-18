package com.matricula.matricula.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matricula.matricula.dto.EstudianteDTO;
import com.matricula.matricula.model.Estudiante;
import com.matricula.matricula.service.IEstudianteService;
import com.matricula.matricula.util.MapperUtil;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/estudiante")
@AllArgsConstructor
public class EstudianteController {
    private final IEstudianteService service;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<EstudianteDTO>> findAll() throws Exception {
        List<EstudianteDTO> list = mapperUtil.map(service.findAll(), EstudianteDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/sortedEdad")
    public ResponseEntity<List<EstudianteDTO>> sortedEdad() throws Exception {
        List<EstudianteDTO> list = mapperUtil.map(service.sortedEdad(), EstudianteDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{idEstudiante}")
    public ResponseEntity<EstudianteDTO> findById(@PathVariable("idEstudiante") Integer idEstudiante) throws Exception {
        EstudianteDTO obj = mapperUtil.map(service.findById(idEstudiante), EstudianteDTO.class);
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<EstudianteDTO> save(@Valid @RequestBody EstudianteDTO dto) throws Exception {
        Estudiante obj = service.save(mapperUtil.map(dto, Estudiante.class));
        return new ResponseEntity<>(mapperUtil.map(obj, EstudianteDTO.class), HttpStatus.CREATED);
    }

    @PutMapping("/{idEstudiante}")
    public ResponseEntity<EstudianteDTO> update(@Valid @PathVariable("idEstudiante") Integer idEstudiante,
            @RequestBody EstudianteDTO dto)
            throws Exception {
        dto.setIdEstudiante(idEstudiante);
        Estudiante obj = service.update(mapperUtil.map(dto, Estudiante.class), idEstudiante);

        return ResponseEntity.ok(mapperUtil.map(obj, EstudianteDTO.class));
    }

    @DeleteMapping("/{idEstudiante}")
    public ResponseEntity<Void> delete(@PathVariable("idEstudiante") Integer idEstudiante) throws Exception {
        service.deleteById(idEstudiante);
        return ResponseEntity.noContent().build();
    }
}
