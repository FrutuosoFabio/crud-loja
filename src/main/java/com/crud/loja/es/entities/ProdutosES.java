package com.crud.loja.es.entities;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "produtos")
public class ProdutosES implements Serializable {
    @Id
    private String Id;
    @Field(type = FieldType.Nested)
    private CategoriaES categorias;
    private String nome;
    private String descricao;
    private Date data_de_compra;
    private String codigo;
    private String tsp_ncm;
    private Float valor;

    public CategoriaES getCategorias() {
        return categorias;
    }

    public void setCategorias(CategoriaES categorias) {
        this.categorias = categorias;
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

    public Date getData_de_compra() {
        return data_de_compra;
    }

    public void setData_de_compra(Date data_de_compra) {
        this.data_de_compra = data_de_compra;
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

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    
}
