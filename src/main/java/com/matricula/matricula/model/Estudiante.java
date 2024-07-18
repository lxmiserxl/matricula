package com.matricula.matricula.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idEstudiante;

    @Column(length = 250, nullable = false)
    private String nombres;

    @Column(length = 350, nullable = false)
    private String apellidos;

    @Column(length = 8, nullable = false)
    private String dni;

    @Column(nullable = false)
    private Integer edad = 0;
}
