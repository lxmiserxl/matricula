package com.matricula.matricula.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Embeddable
@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatriculaDetallePK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_matricula", nullable = false, foreignKey = @ForeignKey(name = "fk_MatriculaDetalle_01"))
    @EqualsAndHashCode.Include
    private Matricula matricula;

    @EqualsAndHashCode.Include
    private Integer idMatriculaDetalle;

    public MatriculaDetallePK(Integer idMatricula, Integer idMatriculaDetalle) {
        this.matricula = new Matricula();
        this.matricula.setIdMatricula(idMatricula);
        this.idMatriculaDetalle = idMatriculaDetalle;
    }
}
