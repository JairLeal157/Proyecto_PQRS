package com.udea.pqrs.model.dto;


import com.udea.pqrs.model.enums.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
@ApiModel(description = "All details about the PQRS. ")
public class Pqrs {
    @ApiModelProperty(notes = "The database generated PQRS ID")
    private Integer id;

    @ApiModelProperty(notes = "The PQRS type")
    private PqrsTypes tipoPqrs;

    @ApiModelProperty(notes = "Who created the PQRS")
    private Integer creadoPor;

    @ApiModelProperty(notes = "Who is the PQRS for")
    private Integer quejaHacia;

    @ApiModelProperty(notes = "what is the role of the PQRS creator")
    private String creadoPorRol;

    @ApiModelProperty(notes = "The PQRS state")
    private PqrsStates estadoPqrs;

    @ApiModelProperty(notes = "Who is admin for the PQRS")
    private Long admin;

    @ApiModelProperty(notes = "Date of creation")
    private Date fechaCreacion;

    @ApiModelProperty(notes = "The PQRS state of approval")
    private Approved estadoAprobacion;

    @ApiModelProperty(notes = "Description of the PQRS")
    private String descripcionPqrs;

    @ApiModelProperty(notes = "if the pqrs is a complaint, what type of complaint is it")
    private ComplainType tipoQueja;

    @ApiModelProperty(notes = "if the pqrs is a claim, what type of claim is it")
    private GrievanceType tipoReclamo;
}
