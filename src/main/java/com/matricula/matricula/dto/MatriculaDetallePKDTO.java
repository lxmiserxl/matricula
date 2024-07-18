package com.matricula.matricula.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MatriculaDetallePKDTO {
    private MatriculaDTO matricula;

    @Min(0)
    private Integer idMatriculaDetalle;
}
