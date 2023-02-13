package com.thommache.springboot.app.serviceImpl;


import com.thommache.springboot.app.dao.ICrudCalificacionDAO;
import com.thommache.springboot.app.dto.CalificacionDTO;
import com.thommache.springboot.app.dto.CalificacionesAlumnosDTO;
import com.thommache.springboot.app.dto.ResponseDTO;
import com.thommache.springboot.app.enties.Calificacion;
import com.thommache.springboot.app.services.CalificacionService;
import com.thommache.springboot.app.utils.MensajesDeError;
import com.thommache.springboot.app.utils.MensajesDeExito;
import com.thommache.springboot.app.utils.ResponseBuilderHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("calificacionServiceImp")
public class CalificacionServiceImp implements CalificacionService {

    @Autowired
    private ICrudCalificacionDAO iCalifiacion;

    @Autowired
    private ResponseBuilderHelper responseBuilderHelper;

    @Override
    public ResponseDTO guardarCalificacion(CalificacionDTO calificacion) {
        try {
            if(iCalifiacion.guardarCalificacion(calificacion)) {
                return new ResponseDTO( MensajesDeExito.EXITO, MensajesDeExito.CALIFICACION_REGISTRADA);
            }else {
                return new ResponseDTO( MensajesDeError.FALLO, MensajesDeError.CALIFICACION_NO_REGISTRADA);
            }
        }catch(Exception e) {
            return new ResponseDTO( MensajesDeError.FALLO, "OCURRIO UNA EXEPCION AL GUARDAR LA CALIFICACION "
                    + "EN LA BD, DESCRIPCION : " + e);
        }

    }

    @Override
    public ResponseDTO actualizarCalificacion(CalificacionDTO calificacion) {
        try {
            if(iCalifiacion.actualizarCalificacion(calificacion)) {
                return new ResponseDTO( MensajesDeExito.EXITO, MensajesDeExito.CALIFICACION_ACTUALIZADA);
            }else {
                return new ResponseDTO( MensajesDeError.FALLO, MensajesDeError.CALIFICACION_NO_ACTUALIZADA);
            }
        }catch(Exception e) {
            return new ResponseDTO( MensajesDeError.FALLO, "OCURRIO UNA EXEPCION AL ACTUALIZAR LA CALIFICACION "
                    + "EN LA BD, DESCRIPCION : " + e);
        }

    }

    @Override
    public ResponseDTO eliminarCalificacion(CalificacionDTO calificacion) {
        try {
            if(iCalifiacion.eliminarCalificacion(calificacion)) {
                return new ResponseDTO( MensajesDeExito.EXITO, MensajesDeExito.CALIFICACION_ELIMINADA);
            }else {
                return new ResponseDTO( MensajesDeError.FALLO, MensajesDeError.CALIFICACION_NO_ELIMINADA);
            }
        }catch(Exception e) {
            return new ResponseDTO(MensajesDeError.FALLO, "OCURRIO UNA EXEPCION AL ELIMINAR LA CALIFICACION "
                    + "EN LA BD, DESCRIPCION : " + e);
        }

    }

    @Override
    public CalificacionesAlumnosDTO obtenerCalificacionesPorUsuario(CalificacionDTO calificacionDTO) {

        List<Calificacion> calificionesAlumnos;
        System.out.println(calificacionDTO.getIdAlumno() + " CalificacionServiceImp");
       try {
           calificionesAlumnos = iCalifiacion.obtenerCalificacionesPorUsuario(calificacionDTO);
        } catch (Exception ex) {
            return new CalificacionesAlumnosDTO( MensajesDeError.FALLO, MensajesDeError.CALIFICACIONES_NO_DISPONIBLES,
                    "OCURRIO UNA EXCEPCION, " + "DURANTE LA CONSULTA, LA CAUSA ES: " + ex.getMessage());
        }
        if (calificionesAlumnos != null && calificionesAlumnos.size() > 0) {
            return new CalificacionesAlumnosDTO(MensajesDeExito.EXITO, MensajesDeExito.EXITO,
                    MensajesDeExito.CALIFICACIONES,responseBuilderHelper.buildCalificacionesAlumnoResponse(calificionesAlumnos));
        } else {
            return new CalificacionesAlumnosDTO(MensajesDeError.FALLO, MensajesDeError.CALIFICACIONES_NO_DISPONIBLES,
                    MensajesDeError.SIN_COINCIDENCIAS + "PARA ALUMNOS CON EL ID "
                            + calificacionDTO.getIdAlumno());
        }

    }



}
