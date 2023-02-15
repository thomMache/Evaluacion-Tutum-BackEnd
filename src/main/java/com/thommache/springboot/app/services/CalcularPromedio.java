package com.thommache.springboot.app.services;

import com.thommache.springboot.app.entity.Calificacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalcularPromedio {

    @Autowired
    private CalificacionService service;

    public List<Calificacion> CalculatePromedio(Calificacion calificacion){

        service.listarCalificacionesPorAlumnoId(calificacion.getAlumno().getId());

        Double promedio = sacarPromedio(calificacion.getCalificacion(), Math.toIntExact(calificacion.getMateria().getId()));

        return null;
    }

    public static Double sacarPromedio(Double cal,  Integer materias){
        return (cal * (0/100) * cal);
    }
}
