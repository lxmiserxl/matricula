package com.matricula.matricula.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@IdClass(MatriculaDetallePK.class)
public class MatriculaDetalle {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_matricula", nullable = false, foreignKey = @ForeignKey(name = "fk_MatriculaDetalle_01"))
    @EqualsAndHashCode.Include
    private Matricula matricula;

    @Id
    @EqualsAndHashCode.Include
    private Integer idMatriculaDetalle;

    @ManyToOne
    @JoinColumn(name = "id_curso", nullable = false, foreignKey = @ForeignKey(name = "fk_MatriculaDetalle_02"))
    private Curso curso;

    @Column(nullable = false)
    private String aula;

    @Column(nullable = false)
    private Boolean estado = true;

}
