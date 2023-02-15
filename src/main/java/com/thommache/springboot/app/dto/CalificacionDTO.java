package com.thommache.springboot.app.dto;

import com.thommache.springboot.app.entity.Alumno;
import com.thommache.springboot.app.entity.Materia;
import lombok.Data;

import java.util.Date;

@Data
public class CalificacionDTO {

    private Long id;

    private double calificacion;

    private Date fechaRegistro;

    private Alumno alumno;

    private Materia materia;
}
