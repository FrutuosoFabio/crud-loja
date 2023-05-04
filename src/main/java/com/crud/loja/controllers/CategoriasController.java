package com.crud.loja.controllers;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.loja.es.entities.CategoriaES;
import com.crud.loja.es.repositories.CategoriaRepositoryES;
import com.crud.loja.mongo.entities.Categoria;
import com.crud.loja.mongo.repositories.CategoriaRepository;
import com.crud.loja.services.ServicoProduto;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriasController {

    @Autowired
    private CategoriaRepository repository;
    @Autowired
    private CategoriaRepositoryES respositoryes;

    @Autowired
    private ServicoProduto produto;

    @GetMapping(value = "")
    public ResponseEntity<List<Categoria>> findall() {
        List<Categoria> obj = repository.findAll();
        return ResponseEntity.ok(obj);
    }

    @GetMapping(value = "/es")
    public ResponseEntity<Iterable<CategoriaES>> findalles() {
        Iterable<CategoriaES> obj = respositoryes.findAll();
        return ResponseEntity.ok(obj);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable ObjectId id) {
        Categoria obj = repository.findById(id).get();
        return ResponseEntity.ok(obj);
    }
    /*
     * @GetMapping(value = "/search")
     * public ResponseEntity<Categoria> findByProduto(@RequestParam String produto) {
     * Categoria obj = repository.findByNome(produto);
     * return ResponseEntity.ok(obj);
     * }
     */

    @GetMapping(value = "/searchAll")
    public ResponseEntity<List<CategoriaES>> buscarUsuarios(@RequestParam String produto) {
        List<CategoriaES> obj = respositoryes.findByNomeContains(produto);
        return ResponseEntity.ok(obj);
    }
/*
    @PostMapping(value = "/cadastrar")
    public ResponseEntity<Categoria> create(@RequestBody Categoria obj) {
        // String id = new String();
        // obj.setId(id);
        // obj.getCategoria().setId(id);
        obj = produto.create(obj);
        // URI uri =
        // ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.ok(obj);

    }

    @PutMapping(value = "/editar")
    public ResponseEntity<Categoria> edit(@RequestBody Categoria obj) {

        obj = produto.edit(obj);
        // URI uri =
        // ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.ok(obj);

    }

    @PostMapping(value = "/cadastrar/lista")
    public ResponseEntity<List<Categoria>> createlista(@RequestBody List<Categoria> obj) {
        obj = produto.create(obj);
        // URI uri =
        // ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.ok(obj);

    }

    @DeleteMapping(value = "/deletar/{id}")
    public ResponseEntity<String> deleteById(@PathVariable ObjectId id) {

        try {
            repository.deleteById(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        {

        }
        return ResponseEntity.ok("deletado com sucesso");

    }
    */
    @DeleteMapping(value = "/deletar/tudo")
    public ResponseEntity<String> deleteById() {

        try {
            List<Categoria> obj = repository.findAll();
            repository.deleteAll(obj);
            Iterable<CategoriaES> objes = respositoryes.findAll();
            respositoryes.deleteAll(objes);
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        {

        }
        return ResponseEntity.ok("deletado com sucesso");

    }
}
