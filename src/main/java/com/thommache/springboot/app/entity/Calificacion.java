package com.thommache.springboot.app.entity;



import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "t_calificaciones")
public class Calificacion  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_t_calificaciones")
    private Long id;

    @NotNull
    private Double calificacion;

    @NotNull
    @Column(name = "fecha_registro")
    private Date fecha;


    @Column(name = "id_t_alumnos")
    private Long idAlumnos;

    @Column(name = "id_t_materias")
    private Long idMaterias;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Long getIdAlumnos() {
        return idAlumnos;
    }

    public void setIdAlumnos(Long idAlumnos) {
        this.idAlumnos = idAlumnos;
    }

    public Long getIdMaterias() {
        return idMaterias;
    }

    public void setIdMaterias(Long idMaterias) {
        this.idMaterias = idMaterias;
    }
}

