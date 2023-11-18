package com.udea.pqrs.model.dto;


import com.udea.pqrs.model.enums.*;
import lombok.Data;

import java.util.Date;

@Data
public class Pqrs {
    private Integer id;
    private PqrsTypes tipoPqrs;
    private Integer creadoPor;
    private Integer quejaHacia;
    private String creadoPorRol;
    private PqrsStates estadoPqrs;
    private Long admin;
    private Date fechaCreacion;
    private Approved estadoAprobacion;
    private String descripcionPqrs;
    private ComplainType tipoQueja;
    private GrievanceType tipoReclamo;
}
