package com.crud.loja.es.services;

import org.springframework.stereotype.Service;

import com.crud.loja.es.entities.CategoriaES;
import com.crud.loja.es.entities.ProdutosES;
import com.crud.loja.mongo.entities.Produtos;

@Service
public class ParserEntidadesEs {


    public ProdutosES parsear(Produtos prod) {
        ProdutosES prodEs = new ProdutosES();
        CategoriaES catEs = new CategoriaES();
        catEs.setNome(prod.getCategoria().getNome());
        catEs.setId(prod.getCategoria().getId().toString());
        prodEs.setCategorias(catEs);
        prodEs.setCodigo(prod.getCodigo());
        prodEs.setTsp_ncm(prod.getTsp_ncm());
        prodEs.setNome(prod.getNome());
        prodEs.setValor(prod.getValor());
        prodEs.setDescricao(prod.getDescricao());
        prodEs.setData_de_compra(prod.getData_de_compra());
       

        return prodEs;

    }

}
