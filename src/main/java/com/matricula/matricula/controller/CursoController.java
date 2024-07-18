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

import com.matricula.matricula.dto.CursoDTO;
import com.matricula.matricula.model.Curso;
import com.matricula.matricula.service.ICursoService;
import com.matricula.matricula.util.MapperUtil;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/curso")
@AllArgsConstructor
public class CursoController {
    private final ICursoService service;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<CursoDTO>> findAll() throws Exception {
        List<CursoDTO> list = mapperUtil.map(service.findAll(), CursoDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{idCurso}")
    public ResponseEntity<CursoDTO> findById(@PathVariable("idCurso") Integer idCurso) throws Exception {
        CursoDTO obj = mapperUtil.map(service.findById(idCurso), CursoDTO.class);
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<CursoDTO> save(@Valid @RequestBody CursoDTO dto) throws Exception {
        Curso obj = service.save(mapperUtil.map(dto, Curso.class));
        return new ResponseEntity<>(mapperUtil.map(obj, CursoDTO.class), HttpStatus.CREATED);
    }

    @PutMapping("/{idCurso}")
    public ResponseEntity<CursoDTO> update(@Valid @PathVariable("idCurso") Integer idCurso, @RequestBody CursoDTO dto)
            throws Exception {
        dto.setIdCurso(idCurso);
        Curso obj = service.update(mapperUtil.map(dto, Curso.class), idCurso);

        return ResponseEntity.ok(mapperUtil.map(obj, CursoDTO.class));
    }

    @DeleteMapping("/{idCurso}")
    public ResponseEntity<Void> delete(@PathVariable("idCurso") Integer idCurso) throws Exception {
        service.deleteById(idCurso);
        return ResponseEntity.noContent().build();
    }
}
