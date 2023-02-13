package com.thommache.springboot.app.dao.impl;

import com.thommache.springboot.app.dao.ICrudCalificacionDAO;
import com.thommache.springboot.app.dto.CalificacionDTO;
import com.thommache.springboot.app.enties.Calificacion;
import com.thommache.springboot.app.repository.CalificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component("crudDAOImpl")
public class CrudDAOImpl  implements ICrudCalificacionDAO {

    @Autowired
    private CalificacionRepository  calificacionRepository;


    @Override
    public boolean guardarCalificacion(CalificacionDTO calificacionDTO) {
        Calificacion calificacionModel = new Calificacion();
        calificacionModel.setCalificacion(calificacionDTO.getCalificacion());
        calificacionModel.setFecha(new Date());
     //   calificacionModel.setIdAlumnos(calificacionDTO.getIdAlumno());
     //   calificacionModel.setIdMaterias(calificacionDTO.getIdMateria());

        calificacionRepository.save(calificacionModel);

        return true;
    }

    @Override
    public boolean actualizarCalificacion(CalificacionDTO calificacionDTO) {
        Calificacion calificacionModel ;
        try {

            calificacionModel = calificacionRepository.getReferenceById(calificacionDTO.getId());

            calificacionModel.setCalificacion(calificacionDTO.getCalificacion());
            calificacionModel.setFecha(calificacionDTO.getFechaRegistro());
       //     calificacionModel.setIdAlumnos(calificacionDTO.getIdAlumno());
        //    calificacionModel.setIdMaterias(calificacionDTO.getIdMateria());

            calificacionRepository.save(calificacionModel);
        }catch(Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean eliminarCalificacion(CalificacionDTO calificacionDTO) {
        try {
            calificacionRepository.deleteById(calificacionDTO.getId());
            return true;
        }catch(Exception e) {
            return false;
        }
    }

    @Override
    public List<Calificacion> obtenerCalificacionesPorUsuario(CalificacionDTO calificacionDTO) {
        System.out.println(calificacionDTO.getIdAlumno() + " CrudDAOImpl");
        List<Calificacion> calificacionList ;
      //  calificacionList = (List<Calificacion>) calificacionRepository.getReferenceById(calificacionDTO.getId());
        calificacionList = calificacionRepository.findAll();
        if (calificacionList != null) {
            System.out.println(calificacionList + " CrudDAOImpl22222222222");
            return calificacionList;
        } else {
            return new ArrayList();
        }
    }
}
