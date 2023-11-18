package com.udea.pqrs.model.repository;


import com.udea.pqrs.model.entity.PqrsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface PqrsRepository extends CrudRepository<PqrsEntity, Integer> {
    Optional<PqrsEntity> findById(Integer id);
    ArrayList<PqrsEntity> findAll(); // buscar todas las pqrs
    ArrayList<PqrsEntity> findByCreadoPor(Integer creadoPor); // buscar todas las pqrs por el id del creador

    PqrsEntity save(PqrsEntity pqrsEntity); // guardar una pqrs

    void delete(PqrsEntity pqrsEntity); // eliminar una pqrs}

    void deleteById(Integer id); // eliminar una pqrs por id


}
