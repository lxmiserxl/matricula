package com.matricula.matricula.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EstudianteDTO {
    private Integer idEstudiante;

    @NotNull
    @Size(min = 2, max = 250)
    private String nombres;

    @NotNull
    @Size(min = 2, max = 350)
    private String apellidos;

    @NotNull
    @Size(min = 8, max = 8)
    private String dni;

    @Min(0)
    @Max(180)
    private Integer edad;
}
