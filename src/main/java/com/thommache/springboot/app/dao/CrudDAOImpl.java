package com.thommache.springboot.app.dao;

import com.thommache.springboot.app.dao.impl.ICrudCalificacionDAO;
import com.thommache.springboot.app.dto.CalificacionDTO;
import com.thommache.springboot.app.dto.CalificacionRequest;
import com.thommache.springboot.app.entity.Calificacion;
import com.thommache.springboot.app.repositories.CalificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component("crudDAOImpl")
public class CrudDAOImpl implements ICrudCalificacionDAO {

    @Autowired
    private CalificacionRepository calificacionRepository;

    @Override
    public boolean guardarCalificacion(CalificacionRequest calificacionDTO) {
        Calificacion calificacionModel = new Calificacion();
        calificacionModel.setCalificacion(calificacionDTO.getCalificacion());
        calificacionModel.setFecha(calificacionDTO.getFecha());
        calificacionModel.setAlumno(calificacionDTO.getAlumno());
        calificacionModel.setMateria(calificacionDTO.getMateria());

        calificacionRepository.save(calificacionModel);

        return true;
    }
}
