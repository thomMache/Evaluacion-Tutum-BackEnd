package com.thommache.springboot.app.repository;

import com.thommache.springboot.app.dto.CalificacionDTO;
import com.thommache.springboot.app.enties.Calificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalificacionRepository  extends JpaRepository<Calificacion, Long> {

  //  List<Calificacion> findByIdAlumnos(Long id);

   // List<Calificacion> findByIdAlumnos(Long id);
   // List<Calificacion> findAll();
}
