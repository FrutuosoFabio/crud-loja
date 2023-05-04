package com.crud.loja.mongo.repositories;



import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


import com.crud.loja.mongo.entities.Categoria;
import com.crud.loja.mongo.entities.Ecommerce;
import com.crud.loja.mongo.entities.Paises;

public interface EccomerceRepository extends MongoRepository<Ecommerce, ObjectId> {

    Ecommerce findFirstByNome(String Nome);
}
