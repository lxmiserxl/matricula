package com.matricula.matricula.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MatriculaDTO {
    private Integer idMatricula;

    @NotNull
    private EstudianteDTO estudiante;

    private LocalDate fechaMatricula;

    private boolean estado;

    @JsonManagedReference
    List<MatriculaDetalleDTO> matriculaDetalle;
}
