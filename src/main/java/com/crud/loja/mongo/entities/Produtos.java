package com.crud.loja.mongo.entities;

import java.io.Serializable;
import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "produtos")
public class Produtos implements Serializable {
    private static final long serialVersionUID = 1L;

    @MongoId
    private ObjectId id;
    private String nome;
    private String descricao;
    private String codigo;
    private String tsp_ncm;
    private Date data_de_compra;
    private Float valor;
    @DBRef
    private Categoria categoria;
    @DBRef
    private Paises pais_de_origem;
    @DBRef
    private Ecommerce ecommerce;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTsp_ncm() {
        return tsp_ncm;
    }

    public void setTsp_ncm(String tsp_ncm) {
        this.tsp_ncm = tsp_ncm;
    }

    public Date getData_de_compra() {
        return data_de_compra;
    }

    public void setData_de_compra(Date data_de_compra) {
        this.data_de_compra = data_de_compra;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Paises getPais_de_origem() {
        return pais_de_origem;
    }

    public void setPais_de_origem(Paises pais_de_origem) {
        this.pais_de_origem = pais_de_origem;
    }

    public Ecommerce getEcommerce() {
        return ecommerce;
    }

    public void setEcommerce(Ecommerce ecommerce) {
        this.ecommerce = ecommerce;
    }

}
