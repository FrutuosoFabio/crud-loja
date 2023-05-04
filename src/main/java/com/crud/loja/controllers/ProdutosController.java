package com.crud.loja.controllers;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.loja.es.entities.ProdutosES;
import com.crud.loja.es.repositories.ProdutoRepositoryES;
import com.crud.loja.mongo.entities.Produtos;
import com.crud.loja.mongo.repositories.ProdutoRepository;
import com.crud.loja.services.ServicoProduto;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutosController {

    @Autowired
    private ProdutoRepository repository;
    @Autowired
    private ProdutoRepositoryES respositoryes;

    @Autowired
    private ServicoProduto produto;

    @GetMapping(value = "/")
    public ResponseEntity<List<Produtos>> findall() {
        List<Produtos> obj = repository.findAll();
        return ResponseEntity.ok(obj);
    }

    @GetMapping(value = "/es")
    public ResponseEntity<Iterable<ProdutosES>> findalles() {
        Iterable<ProdutosES> obj = respositoryes.findAll();
        return ResponseEntity.ok(obj);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Produtos> findById(@PathVariable ObjectId id) {
        Produtos obj = repository.findById(id).get();
        return ResponseEntity.ok(obj);
    }
    /*
     * @GetMapping(value = "/search")
     * public ResponseEntity<Produtos> findByProduto(@RequestParam String produto) {
     * Produtos obj = repository.findByNome(produto);
     * return ResponseEntity.ok(obj);
     * }
     */

    @GetMapping(value = "/searchAll")
    public ResponseEntity<List<ProdutosES>> buscarUsuarios(@RequestParam String produto) {
        List<ProdutosES> obj = respositoryes.findByNomeContains(produto);
        return ResponseEntity.ok(obj);
    }

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<Produtos> create(@RequestBody Produtos obj) {
        // String id = new String();
        // obj.setId(id);
        // obj.getCategoria().setId(id);
        obj = produto.create(obj);
        // URI uri =
        // ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.ok(obj);

    }

    @PutMapping(value = "/editar")
    public ResponseEntity<Produtos> edit(@RequestBody Produtos obj) {

        obj = produto.edit(obj);
        // URI uri =
        // ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.ok(obj);

    }

    @PostMapping(value = "/cadastrar/lista")
    public ResponseEntity<List<Produtos>> createlista(@RequestBody List<Produtos> obj) {
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
    @DeleteMapping(value = "/deletar/tudo")
    public ResponseEntity<String> deleteById() {

        try {
            List<Produtos> obj = repository.findAll();
            repository.deleteAll(obj);
            Iterable<ProdutosES> objes = respositoryes.findAll();
            respositoryes.deleteAll(objes);
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        {

        }
        return ResponseEntity.ok("deletado com sucesso");

    }
}
