package com.thommache.springboot.app.services;

import com.thommache.springboot.app.dto.CalificacionDTO;
import com.thommache.springboot.app.dto.CalificacionRequest;
import com.thommache.springboot.app.dto.ResponseDTO;

public interface CalificacionesService {
    ResponseDTO guardarCalificacion(CalificacionRequest calificacion);
}
