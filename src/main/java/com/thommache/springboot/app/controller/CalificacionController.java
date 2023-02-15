package com.thommache.springboot.app.controller;

import com.thommache.springboot.app.dto.CalificacionDTO;
import com.thommache.springboot.app.dto.CalificacionRequest;
import com.thommache.springboot.app.dto.ResponseDTO;
import com.thommache.springboot.app.entity.Calificacion;
import com.thommache.springboot.app.services.CalificacionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin({"http://localhost:4200"})
@RequestMapping("/calificaciones")
public class CalificacionController {

    @Autowired
    private CalificacionService service;

    @Autowired
    private com.thommache.springboot.app.serviceImpl.CalificacionesServiceImpl calificacionServiceImpl;

    @GetMapping("/{idAlumno}")
    public ResponseEntity<List<Calificacion>> listarCalificacionesPorAlumnoId(@PathVariable Long idAlumno) {
      return ResponseEntity.ok(service.listarCalificacionesPorAlumnoId(idAlumno));
    }

 /*   @PostMapping
    public ResponseEntity<Calificacion> guardar(@Valid @RequestBody Calificacion calificacion, BindingResult result) {
   /*   if (result.hasErrors()) {
            return validar(result);
        }
        System.out.println(calificacion.getCalificacion() + " bbbbbbbbbbbbbbbbbbbbbb");
        System.out.println(calificacion.getAlumno() + " 00000000000");
        System.out.println(calificacion.getMateria()+ " aaaaaaaaaaaaa");

        Calificacion calificacionDb = service.guardar(calificacion);
        Map<String, String> msg = new HashMap<>();
        msg.put("msg","calificacion actualizada");
        msg.put("success","ok");
        return new ResponseEntity<>(calificacionDb,HttpStatus.OK);
       // return ResponseEntity.status(HttpStatus.CREATED).body(calificacionDb);
    }*/


    @PostMapping
    public ResponseEntity<ResponseDTO> guardar(@RequestBody CalificacionRequest requestPayload) {
        ResponseEntity<ResponseDTO> response = new ResponseEntity<ResponseDTO>(calificacionServiceImpl.guardarCalificacion(requestPayload), HttpStatus.OK);
        return response;
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
            calificacionDb.setAlumno(calificacion.getAlumno());
            calificacionDb.setMateria(calificacion.getMateria());
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
            return new ResponseEntity<>(msg, HttpStatus.OK);
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
