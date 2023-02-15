package com.thommache.springboot.app.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.thommache.springboot.app.entity.Alumno;
import com.thommache.springboot.app.entity.Materia;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class CalificacionRequest {

    @NotNull(message = "amount is required")
    @JsonAlias("id")
    private Integer id;
    @NotNull(message = "terms is required")
    @JsonAlias("calificacion")
    private Double calificacion;
    @NotNull(message = "rate is required")
    @JsonAlias("fecha")
    private Date fecha;
    @NotNull(message = "rate is required")
    @JsonAlias("alumno_id")
    private Alumno alumno;
    @NotNull(message = "rate is required")
    @JsonAlias("materia_id")
    private Materia materia;
}
