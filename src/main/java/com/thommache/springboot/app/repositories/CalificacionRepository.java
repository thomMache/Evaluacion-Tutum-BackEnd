package com.thommache.springboot.app.repositories;

import com.thommache.springboot.app.dto.CalificacionDTO;
import com.thommache.springboot.app.entity.Calificacion;
import jakarta.transaction.Transactional;
import org.hibernate.annotations.NamedNativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

@Transactional
public interface CalificacionRepository extends CrudRepository<Calificacion, Long> {

   // @Query("Select u from Calificacion u where u.idAlumnos=?1")
    //List<Calificacion> findByIdAlumnos(Long idAlumno);

    @Query(value = "Select u.id_t_calificaciones" +
            //"u.calificacion,u.fecha_registro, b.nombre,b.ap_paterno, l.nombre from t_calificaciones u" +
            " join t_alumnos b ON  u.id_t_alumnos=b.id_t_usuarios join t_materias l on u.id_t_materias=l.id_t_materias WHERE u.id_t_Alumnos = ?1", nativeQuery = true)
    List<CalificacionDTO> findByIdAlumnos(Long idAlumno);
}
