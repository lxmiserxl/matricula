package com.matricula.matricula.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MatriculaDetalleDTO {
    @JsonBackReference
    private MatriculaDTO matricula;

    @NotNull
    @Min(0)
    private Integer idMatriculaDetalle;

    @NotNull
    private CursoDTO curso;

    @NotNull
    private String aula;

    private Boolean estado;
}
