package com.udea.pqrs.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "PQRS")
public class PqrsEntity {
    @Id
    @Column(name = "ID_PQRS", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "TIPO_PQRS", nullable = false)
    private String tipoPqrs;

    @Column(name = "CREADO_POR")
    private Integer creadoPor;

    @Column(name = "QUEJA_HACIA")
    private Integer quejaHacia;


    @Column(name = "CREADO_POR_ROL")
    private String creadoPorRol;


    @Column(name = "ESTADO_PQRS")
    private String estadoPqrs;

    @Column(name = "ID_ADMIN")
    private Long idAdmin;

    @Column(name = "ESTADO_APROBACION")
    private String estadoAprobacion;

    @Column(name = "FECHA_CREACION")
    private LocalDate fechaCreacion;


    @Column(name = "DESCRIPCION_PQRS")
    private String descripcionPqrs;


    @Column(name = "TIPO_QUEJA")
    private String tipoQueja;


    @Column(name = "TIPO_RECLAMO")
    private String tipoReclamo;

}