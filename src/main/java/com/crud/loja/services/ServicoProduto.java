package com.crud.loja.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.loja.es.entities.CategoriaES;
import com.crud.loja.es.entities.ProdutosES;
import com.crud.loja.es.repositories.ProdutoRepositoryES;
import com.crud.loja.es.services.ParserEntidadesEs;
import com.crud.loja.mongo.entities.Categoria;
import com.crud.loja.mongo.entities.Ecommerce;
import com.crud.loja.mongo.entities.Paises;
import com.crud.loja.mongo.entities.Produtos;
import com.crud.loja.mongo.repositories.CategoriaRepository;
import com.crud.loja.mongo.repositories.EccomerceRepository;
import com.crud.loja.mongo.repositories.PaisesRepository;
import com.crud.loja.mongo.repositories.ProdutoRepository;

@Service
public class ServicoProduto {

    @Autowired
    ProdutoRepository prodrepo;
    @Autowired
    ProdutoRepositoryES prodrepoEs;
    @Autowired
    CategoriaRepository catRepo;
    @Autowired
    PaisesRepository paiRepo;
    @Autowired
    EccomerceRepository ecoRepo;

    @Autowired
    ParserEntidadesEs parseenti;

    public Produtos create(Produtos obj) {
        Categoria cat = obj.getCategoria();
        if (obj.getCategoria().getId() != null) {
            cat = catRepo.findById(obj.getCategoria().getId()).get();
        }
        if (obj.getCategoria().getNome() != null) {
            cat = catRepo.findFirstByNome(obj.getCategoria().getNome().toString());
        }
        if (cat == null || cat.equals("")) {
            cat = new Categoria();
            cat.setNome(obj.getCategoria().getNome());
            cat = catRepo.save(cat);

        }
        Paises pai = obj.getPais_de_origem();
        if (obj.getPais_de_origem().getId() != null) {
            pai = paiRepo.findById(obj.getPais_de_origem().getId()).get();
        }
        if (obj.getPais_de_origem().getNome() != null) {
            pai = paiRepo.findFirstByNome(obj.getPais_de_origem().getNome().toString());
        }
        if (pai == null || pai.equals("")) {
            pai = new Paises();
            pai.setNome(obj.getPais_de_origem().getNome());
            pai = paiRepo.save(pai);

        }
        Ecommerce eco = obj.getEcommerce();
        if (obj.getEcommerce().getId() != null) {
            eco = ecoRepo.findById(obj.getEcommerce().getId()).get();
        }
        if (obj.getPais_de_origem().getNome() != null) {
            eco = ecoRepo.findFirstByNome(obj.getEcommerce().getNome().toString());
        }
        if (eco == null || eco.equals("")) {
            eco = new Ecommerce();
            eco.setNome(obj.getEcommerce().getNome());
            eco = ecoRepo.save(eco);
        }
        obj.setEcommerce(eco);
        obj.setPais_de_origem(pai);
        obj.setCategoria(cat);
        Produtos teste = prodrepo.save(obj);
        ProdutosES produtoES = parseenti.parsear(teste);
        prodrepoEs.save(produtoES);

        return teste;
    }

    public Produtos edit(Produtos obj) {
        Produtos old = prodrepo.findByNome(obj.getNome());
        // old.setCategoria(obj.getCategoria());
        old.setDescricao(obj.getDescricao());
        old.setNome(obj.getNome());
        old.setValor(obj.getValor());
        ProdutosES prodEs = parseenti.parsear(obj);
        prodrepo.save(old);
        prodrepoEs.save(prodEs);

        return old;
    }

    public List<Produtos> create(List<Produtos> obj) {
        for (Produtos produtos : obj) {
            prodrepo.save(produtos);
        }
        return obj;
    }

}
