package com.thommache.springboot.app.entity;



import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "t_calificaciones")
@Setter @Getter
public class Calificacion  implements  Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Double calificacion;

    @NotNull
    @Column(name = "fecha_registro")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fecha;

    @JsonIgnoreProperties( {"hibernateLazyInitializer", "handler"})
    @OneToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "materia_id", referencedColumnName = "id")
    private Materia materia;

    @JsonIgnoreProperties( {"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "alumno_id",referencedColumnName = "id")
    private Alumno alumno;

    private static final long serialVersionUID = 1L;


}

