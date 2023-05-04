package com.crud.loja.mongo.repositories;



import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


import com.crud.loja.mongo.entities.Categoria;
import com.crud.loja.mongo.entities.Paises;

public interface PaisesRepository extends MongoRepository<Paises, ObjectId> {

    Paises findFirstByNome(String Nome);
}
