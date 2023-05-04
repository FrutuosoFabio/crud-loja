package com.crud.loja.mongo.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import com.crud.loja.mongo.entities.Produtos;



public interface ProdutoRepository extends MongoRepository<Produtos, ObjectId> {

    Produtos findByNome(String Nome);

    //@Query("select p from User p where p.name like :%texto ")
    List<Produtos> findByNomeContains(@Param("texto") String texto);

}
