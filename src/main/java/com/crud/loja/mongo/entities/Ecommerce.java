package com.crud.loja.mongo.entities;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "ecommerce")
public class Ecommerce implements Serializable {
    // private static final long serialVersionUID = 1L;

    @MongoId
    private ObjectId id;

    private String nome;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
}
