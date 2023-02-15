package com.thommache.springboot.app.serviceImpl;


import com.thommache.springboot.app.dao.impl.ICrudCalificacionDAO;
import com.thommache.springboot.app.dto.CalificacionDTO;
import com.thommache.springboot.app.dto.CalificacionRequest;
import com.thommache.springboot.app.dto.ResponseDTO;
import com.thommache.springboot.app.services.CalificacionesService;
import com.thommache.springboot.app.utils.MensajesDeError;
import com.thommache.springboot.app.utils.MensajesDeExito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("calificacionesServiceImp")
public class CalificacionesServiceImpl implements CalificacionesService {

    @Autowired
    private ICrudCalificacionDAO iCalifiacion;

 //   @Autowired
  //  private ResponseBuilderHelper responseBuilderHelper;

    @Override
    public ResponseDTO guardarCalificacion(CalificacionRequest calificacion) {
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

  /*  @Override
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

    }*/


}
