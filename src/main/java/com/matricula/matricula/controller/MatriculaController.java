package com.matricula.matricula.controller;

import java.util.List;
import java.util.Map;

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

import com.matricula.matricula.dto.MatriculaDTO;
import com.matricula.matricula.model.Matricula;
import com.matricula.matricula.service.IMatriculaService;
import com.matricula.matricula.util.MapperUtil;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/matricula")
@AllArgsConstructor
public class MatriculaController {
    private final IMatriculaService service;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<MatriculaDTO>> findAll() throws Exception {
        List<MatriculaDTO> list = mapperUtil.map(service.findAll(), MatriculaDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/sortEdad")
    public ResponseEntity<List<MatriculaDTO>> sortEdad() throws Exception {
        List<MatriculaDTO> list = mapperUtil.map(service.findAll(), MatriculaDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/cursosEstudiantes")
    public ResponseEntity<Map<String, List<String>>> findCursosEstudiantes() throws Exception {
        Map<String, List<String>> cursosEstudiantes = service.findCursosEstudiantes();
        return ResponseEntity.ok(cursosEstudiantes);
    }

    @GetMapping("/{idMatricula}")
    public ResponseEntity<MatriculaDTO> findById(@PathVariable("idMatricula") Integer idMatricula) throws Exception {
        MatriculaDTO obj = mapperUtil.map(service.findById(idMatricula), MatriculaDTO.class);
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<MatriculaDTO> save(@Valid @RequestBody MatriculaDTO dto) throws Exception {
        Matricula obj = service.save(mapperUtil.map(dto, Matricula.class));
        return new ResponseEntity<>(mapperUtil.map(obj, MatriculaDTO.class), HttpStatus.CREATED);
    }

    @PutMapping("/{idMatricula}")
    public ResponseEntity<MatriculaDTO> update(@Valid @PathVariable("idMatricula") Integer idMatricula,
            @RequestBody MatriculaDTO dto)
            throws Exception {
        dto.setIdMatricula(idMatricula);
        Matricula obj = service.update(mapperUtil.map(dto, Matricula.class), idMatricula);

        return ResponseEntity.ok(mapperUtil.map(obj, MatriculaDTO.class));
    }

    @DeleteMapping("/{idMatricula}")
    public ResponseEntity<Void> delete(@PathVariable("idMatricula") Integer idMatricula) throws Exception {
        service.deleteById(idMatricula);
        return ResponseEntity.noContent().build();
    }
}
