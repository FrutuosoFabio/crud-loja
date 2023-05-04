package com.crud.loja.es.repositories;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.query.Param;

import com.crud.loja.es.entities.CategoriaES;
import com.crud.loja.es.entities.ProdutosES;

public interface CategoriaRepositoryES extends ElasticsearchRepository<CategoriaES, String> {

    CategoriaES findByNome(String Nome);

    // @Query("select p from User p where p.name like :%texto ")
    List<CategoriaES> findByNomeContains(@Param("texto") String texto);

}
