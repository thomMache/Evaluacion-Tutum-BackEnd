package com.thommache.springboot.app.repositories;

import com.thommache.springboot.app.entity.Calificacion;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Transactional
public interface CalificacionRepository extends CrudRepository<Calificacion, Long> {

    @Query("Select u from Calificacion u where u.alumno.id=?1")
    List<Calificacion> findByAlumno(Long idAlumno);

}
