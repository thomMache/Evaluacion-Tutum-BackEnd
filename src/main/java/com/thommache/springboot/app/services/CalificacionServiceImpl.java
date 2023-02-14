package com.thommache.springboot.app.services;

import com.thommache.springboot.app.dto.CalificacionDTO;
import com.thommache.springboot.app.entity.Calificacion;
import com.thommache.springboot.app.repositories.CalificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CalificacionServiceImpl  implements  CalificacionService{

    @Autowired
    private CalificacionRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<CalificacionDTO> listarCalificacionesPorAlumnoId(Long idAlumno) {
        return  repository.findByIdAlumnos(idAlumno);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Calificacion> porId(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Calificacion guardar(Calificacion calificacion) {
        return repository.save(calificacion);
    }

    @Override
    @Transactional
    public Calificacion actualizar(Calificacion calificacion) {
        return repository.save(calificacion);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
