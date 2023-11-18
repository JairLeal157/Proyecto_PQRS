package com.udea.pqrs.service.pqrs;

import com.udea.pqrs.model.dto.Pqrs;
import com.udea.pqrs.model.entity.PqrsEntity;
import com.udea.pqrs.model.mapper.PqrsMapper;
import com.udea.pqrs.model.repository.PqrsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PqrsServiceImpl implements IPqrsService {

    @Autowired
    PqrsRepository pqrsRepository; // Repositorio para acceder a la base de datos

    @Autowired
    PqrsMapper pqrsMapper; // Mapper para convertir entre DTO y entidad


    //Crear Pqrs
    @Override
    public Pqrs createPqrs(Pqrs pqrs) {

        // Convierte el DTO a entidad de la base de datos
        PqrsEntity pqrsE = pqrsMapper.toEntity(pqrs);

        // Guarda la entidad en la base de datos
        pqrsE = pqrsRepository.save(pqrsE);

        // Convierte la entidad nuevamente a DTO para la respuesta
        Pqrs pqrsResponse = pqrsMapper.toDto(pqrsE);

        return pqrsResponse;
    }


    //Eliminar Pqrs
    @Override
    public Pqrs deletePqrs(Integer id) {
        Optional<PqrsEntity> pqrsEResult  = pqrsRepository.findById(id);

        //Verifico que exista la pqrs
        if( ! pqrsEResult.isPresent() ) {
            return null;
        }

        PqrsEntity pqrsE = pqrsEResult.get();
        pqrsRepository.delete(pqrsE);

        // Convierte la entidad eliminada a DTO para la respuesta
        Pqrs pqrsResponse = pqrsMapper.toDto(pqrsE);

        return pqrsResponse;
    }

    @Override
    public Iterable<Pqrs> listPqrs() {

        List<PqrsEntity> lista = pqrsRepository.findAll();

        Iterable<Pqrs> listaPqrs = pqrsMapper.toDtoList(lista);

        return listaPqrs;
    }

    @Override
    public Pqrs getPqrsById(Integer id) {

        Optional<PqrsEntity> pqrsEResult  = pqrsRepository.findById(id);

    //Verifico que exista la pqrs
        if(!pqrsEResult.isPresent()) {
            return null;
        }

        return pqrsMapper.toDto(pqrsEResult.get());
    }

}
