package com.thommache.springboot.app.dao;

import com.thommache.springboot.app.dto.CalificacionDTO;
import com.thommache.springboot.app.enties.Calificacion;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("iCrudCalificacionDAO")
public interface ICrudCalificacionDAO {

    boolean guardarCalificacion(CalificacionDTO calificacionDTO);

   boolean actualizarCalificacion(CalificacionDTO calificacionDTO);

    boolean eliminarCalificacion(CalificacionDTO calificacionDTO);

    List<Calificacion> obtenerCalificacionesPorUsuario(CalificacionDTO calificacionDTO);

   // List<Calificacion> getByIdAlumno(CalificacionDTO calificacionDTO);

//   Optional<CalificacionDTO> porId(Long id);
}
