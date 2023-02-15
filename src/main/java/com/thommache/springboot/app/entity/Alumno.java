package com.thommache.springboot.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "t_alumnos")
@Data
public class Alumno  implements  Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 80)
    private String nombre;

    @Column(name = "ap_paterno", length = 80)
    private String apPaterno;

    @Column(name = "ap_materno", length = 80)
    private String apMaterno;

    @Column(scale = 1)
    private Long activo;


}
