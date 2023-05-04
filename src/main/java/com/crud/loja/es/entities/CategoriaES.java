package com.crud.loja.es.entities;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "categorias")
public class CategoriaES implements Serializable {
    // private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String nome;

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(String id) {
        this.id = id;
    }

}
