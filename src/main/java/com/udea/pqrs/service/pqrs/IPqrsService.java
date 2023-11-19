package com.udea.pqrs.service.pqrs;


import com.udea.pqrs.model.dto.Pqrs;

public interface IPqrsService {

    public Pqrs createPqrs(Pqrs pqrs);
    public Pqrs deletePqrs(Integer id);

    //Ajustar para solo mostrar las de usuario que me pasen
    public Iterable<Pqrs> listPqrs();
    public Pqrs getPqrsById(Integer id);


}
