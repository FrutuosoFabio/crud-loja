package com.crud.loja.mongo.repositories;



import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


import com.crud.loja.mongo.entities.Categoria;

public interface CategoriaRepository extends MongoRepository<Categoria, ObjectId> {

    Categoria findFirstByNome(String Nome);
}
