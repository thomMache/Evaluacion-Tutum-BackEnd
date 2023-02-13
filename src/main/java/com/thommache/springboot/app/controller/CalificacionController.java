package com.thommache.springboot.app.controller;


import com.thommache.springboot.app.dto.CalificacionDTO;
import com.thommache.springboot.app.dto.CalificacionesAlumnosDTO;
import com.thommache.springboot.app.dto.ResponseDTO;
import com.thommache.springboot.app.serviceImpl.CalificacionServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/calificaciones")
public class CalificacionController {

    @Autowired
    private CalificacionServiceImp calificacionServiceImpl;

    @PostMapping
    public ResponseEntity<ResponseDTO> crearCalificacion(@RequestBody CalificacionDTO calificacionDto){
         ResponseEntity<ResponseDTO> response = new ResponseEntity<ResponseDTO>(calificacionServiceImpl.guardarCalificacion(calificacionDto), HttpStatus.OK);
        return response;
    }

    @PutMapping
    public ResponseEntity<ResponseDTO> actualizarCalificacion(@RequestBody CalificacionDTO calificacionDto){
        ResponseEntity<ResponseDTO> response = new ResponseEntity<ResponseDTO>(calificacionServiceImpl.actualizarCalificacion(calificacionDto), HttpStatus.OK);
        return response;
    }

    @DeleteMapping
    public ResponseEntity<ResponseDTO> eliminarCalificacion(@RequestBody CalificacionDTO calificacionDto){
        ResponseEntity<ResponseDTO> response = new ResponseEntity<ResponseDTO>(calificacionServiceImpl.eliminarCalificacion(calificacionDto), HttpStatus.OK);
        return response;
    }

    @GetMapping("/porUsuario")
    public ResponseEntity<CalificacionesAlumnosDTO> obtenerCalificacionesPorUsuario(@RequestBody CalificacionDTO calificacionDto){
        ResponseEntity<CalificacionesAlumnosDTO> response = new ResponseEntity<CalificacionesAlumnosDTO>(calificacionServiceImpl.obtenerCalificacionesPorUsuario(calificacionDto), HttpStatus.OK);
        return response;
    }

}
