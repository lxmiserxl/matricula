package com.matricula.matricula.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matricula.matricula.dto.MatriculaDetalleDTO;
import com.matricula.matricula.model.MatriculaDetallePK;
import com.matricula.matricula.service.IMatriculaDetalleService;
import com.matricula.matricula.util.MapperUtil;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/matriculaDetalle")
@AllArgsConstructor
public class MatriculaDetalleController {
    private final IMatriculaDetalleService service;
    private final MapperUtil mapperUtil;

    @GetMapping("/{idMatricula}/{idMatriculaDetalle}")
    public ResponseEntity<MatriculaDetalleDTO> findById(@PathVariable("idMatricula") Integer idMatricula,
            @PathVariable("idMatriculaDetalle") Integer idMatriculaDetalle)
            throws Exception {
        MatriculaDetalleDTO obj = mapperUtil.map(
                service.findById(new MatriculaDetallePK(idMatricula, idMatriculaDetalle)), MatriculaDetalleDTO.class);
        return ResponseEntity.ok(obj);
    }

    @DeleteMapping("/{idMatricula}/{idMatriculaDetalle}")
    public ResponseEntity<Void> delete(@PathVariable("idMatricula") Integer idMatricula,
            @PathVariable("idMatriculaDetalle") Integer idMatriculaDetalle)
            throws Exception {
        service.deleteById(new MatriculaDetallePK(idMatricula, idMatriculaDetalle));
        return ResponseEntity.noContent().build();
    }
}
