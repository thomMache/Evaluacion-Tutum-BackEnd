package com.thommache.springboot.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "t_materias")
@Data
public class Materia implements  Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 80)
    private String nombre;

    @Column(scale = 1)
    private Long activo;

    private static final long serialVersionUID = 1L;
    /*@JsonIgnoreProperties(value={"materia", "hibernateLazyInitializer", "handler"}, allowSetters=true)
    @OneToOne(fetch = FetchType.LAZY)
    private Calificacion calificacion;*/

    @Override
    public String toString() {
        return "Materia{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", activo=" + activo +
                '}';
    }

    public Materia() {
    }

    public Materia(Long id, String nombre, Long activo) {
        this.id = id;
        this.nombre = nombre;
        this.activo = activo;
    }
}
