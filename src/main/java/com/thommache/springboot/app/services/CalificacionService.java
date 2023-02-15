package com.thommache.springboot.app.services;

import com.thommache.springboot.app.dto.CalificacionRequest;
import com.thommache.springboot.app.dto.CalificacionResponse;
import com.thommache.springboot.app.entity.Calificacion;

import java.util.List;
import java.util.Optional;

public interface CalificacionService {
    //List<Calificacion> listarCalificacionesPorAlumnoId(Long idAlumno);

    List<Calificacion> listarCalificacionesPorAlumnoId(Long idAlumno);
    Optional<Calificacion> porId(Long id);
    Calificacion guardar(Calificacion calificacion);
    Calificacion actualizar(Calificacion calificacion);
    void eliminar(Long id);
}
