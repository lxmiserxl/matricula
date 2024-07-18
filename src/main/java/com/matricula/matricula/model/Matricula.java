package com.matricula.matricula.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idMatricula;

    @ManyToOne
    @JoinColumn(name = "id_estudiante", nullable = false, foreignKey = @ForeignKey(name = "Fk_Matricula_01"))
    private Estudiante estudiante;

    @Column(nullable = false)
    private LocalDate fechaMatricula = LocalDate.now();

    @Column(nullable = false)
    private boolean estado = true;

    @OneToMany(mappedBy = "matricula", cascade = CascadeType.ALL)
    List<MatriculaDetalle> matriculaDetalle;

}
