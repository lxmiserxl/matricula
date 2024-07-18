package com.matricula.matricula.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CursoDTO {
    private Integer idCurso;

    @NotNull
    @Size(min = 3, max = 500)
    private String nombre;

    @NotNull
    @Size(min = 1, max = 15)
    private String siglas;

    @NotNull
    private Boolean estado;
}
