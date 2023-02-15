package com.thommache.springboot.app.dao.impl;

import com.thommache.springboot.app.dto.CalificacionDTO;
import com.thommache.springboot.app.dto.CalificacionRequest;
import org.springframework.stereotype.Component;

@Component("iCrudCalificacionDAO")
public interface ICrudCalificacionDAO {
    boolean guardarCalificacion(CalificacionRequest calificacionDTO);
}
