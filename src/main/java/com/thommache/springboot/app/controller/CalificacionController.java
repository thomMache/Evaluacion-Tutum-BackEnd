package com.thommache.springboot.app.controller;

import com.thommache.springboot.app.entity.Calificacion;
import com.thommache.springboot.app.services.CalificacionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/calificaciones")
public class CalificacionController {

    @Autowired
    private CalificacionService service;

    @GetMapping("/{idAlumno}")
    public ResponseEntity<?> listarCalificacionesPorAlumnoId(@PathVariable Long idAlumno) {
      return ResponseEntity.ok(service.listarCalificacionesPorAlumnoId(idAlumno));
    }

    @PostMapping
    public ResponseEntity<?> guardar(@Valid @RequestBody Calificacion calificacion, BindingResult result) {
      if (result.hasErrors()) {
            return validar(result);
        }
        Calificacion calificacionDb = service.guardar(calificacion);
        Map<String, String> msg = new HashMap<>();
        msg.put("msg","calificacion actualizada");
        msg.put("success","ok");
        return ResponseEntity.status(HttpStatus.CREATED).body(calificacionDb);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@Valid  @RequestBody Calificacion calificacion ,BindingResult result,@PathVariable Long id) {
        Optional<Calificacion> o = service.porId(id);

        if (result.hasErrors()) {
            return validar(result);
        }

        if (o.isPresent()) {
            Calificacion calificacionDb = o.get();
            calificacionDb.setCalificacion(calificacion.getCalificacion());
            calificacionDb.setFecha(calificacion.getFecha());
            calificacionDb.setIdAlumnos(calificacion.getIdAlumnos());
            calificacionDb.setIdMaterias(calificacion.getIdMaterias());
            service.actualizar(calificacionDb);
            Map<String, String> msg = new HashMap<>();
            msg.put("msg","calificacion actualizada");
            msg.put("success","ok");
            return ResponseEntity.status(HttpStatus.CREATED).body(msg);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        Optional<Calificacion> o = service.porId(id);


        if (o.isPresent()) {
            Map<String, String> msg = new HashMap<>();
            msg.put("msg","calificacion eliminada");
            msg.put("success","ok");
            service.eliminar(o.get().getId());
            return ResponseEntity.ok().body(msg);
        }
        return ResponseEntity.notFound().build();
    }


    private ResponseEntity<Map<String, String>> validar(BindingResult result) {
        Map<String, String> errores = new HashMap<>();
        result.getFieldErrors().forEach(err -> {
            errores.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errores);
    }



}
