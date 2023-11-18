package com.udea.pqrs.controller;


import com.udea.pqrs.model.dto.Pqrs;
import com.udea.pqrs.service.pqrs.IPqrsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Tag(name = "Pqrs", description = "Recursos de PQRS")

@RestController
@RequestMapping("v1/pqrs")
@CrossOrigin("*")
public class PqrsController {

    @Autowired
    IPqrsService pqrsService;

    // Método para crear una PQRS
    @Operation(summary = "Guardar una pqrss")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = Pqrs.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
            }, description = "La petición se ha procesado correctamente"),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta"),
            @ApiResponse(responseCode = "400", description = "Error en la información")
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public ResponseEntity<Pqrs> createPqrs(@RequestBody Pqrs pqrs){

       Pqrs pqrsCreated= pqrsService.createPqrs(pqrs);

       if (pqrsCreated == null){
           return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
       }

        return new ResponseEntity<>(pqrsCreated,HttpStatus.CREATED);
    }

    // Método para borrar una PQRS
    @Operation(summary = "Borrar una pqrs")
    @ApiResponses({
            // Cambiar el schema
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = Pqrs.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
            }, description = "La petición se ha procesado correctamente"),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta"),
            @ApiResponse(responseCode = "400", description = "Error en la información")
    })
    @DeleteMapping("{id}")
    public ResponseEntity<Pqrs> deletePqrs(@PathVariable("id")  Integer id){

        Pqrs pqrsDeleted= pqrsService.deletePqrs(id);

        if (pqrsDeleted == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(pqrsDeleted,HttpStatus.OK);
    }


    // Método para listar todas las PQRS
    @Operation(summary = "Listar pqrs")
    @ApiResponses({
            // Cambiar el schema
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = Pqrs.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
            }, description = "La petición se ha procesado correctamente"),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta"),
            @ApiResponse(responseCode = "400", description = "Error en la información")
    })
    @GetMapping()
    public ResponseEntity<Iterable<Pqrs>> listPqrs(){

        return new ResponseEntity<>(pqrsService.listPqrs(),HttpStatus.OK);
    }


    // Método para obtener una PQRS por su ID
    @Operation(summary = "Obtener pqrs por id")
    @ApiResponses({
            // Cambiar el schema
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = Pqrs.class), mediaType = MediaType.APPLICATION_JSON_VALUE)
            }, description = "La petición se ha procesado correctamente"),
            @ApiResponse(responseCode = "500", description = "Error interno al procesar la respuesta"),
            @ApiResponse(responseCode = "400", description = "Error en la información")
    })
    @GetMapping(path = "/{id}")
    public ResponseEntity<Pqrs> getPqrsById(@PathVariable("id")  Integer id){

        Pqrs pqrsObtained= pqrsService.getPqrsById(id);

        if (pqrsObtained == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(pqrsObtained,HttpStatus.OK);
    }


}
