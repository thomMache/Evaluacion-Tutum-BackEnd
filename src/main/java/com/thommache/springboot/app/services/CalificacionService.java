package com.thommache.springboot.app.services;

import com.thommache.springboot.app.dto.CalificacionDTO;
import com.thommache.springboot.app.dto.CalificacionesAlumnosDTO;
import com.thommache.springboot.app.dto.ResponseDTO;

public interface CalificacionService {

    ResponseDTO guardarCalificacion(CalificacionDTO calificacion);

    ResponseDTO actualizarCalificacion(CalificacionDTO calificacion);

    ResponseDTO eliminarCalificacion(CalificacionDTO calificacion);

    CalificacionesAlumnosDTO obtenerCalificacionesPorUsuario(CalificacionDTO calificacion);
}
