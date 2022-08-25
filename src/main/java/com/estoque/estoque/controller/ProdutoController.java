package com.estoque.estoque.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estoque.estoque.model.Produto;
import com.estoque.estoque.services.ProdutoService;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

  @Autowired
  private ProdutoService produtoService;

  @GetMapping
  public List<Produto> obterTodos() {
    return produtoService.obterTodos();
  }

  @PostMapping
  public Produto adicionar(@RequestBody Produto produto) {

    return produtoService.adicionar(produto);
  }

  @GetMapping("/{id}")
  public Optional<Produto> obterPorId(@PathVariable Integer id) {
    return produtoService.obterPorId(id);
  }

  @DeleteMapping
  public String deletar(@PathVariable Integer id) {

    produtoService.deletar(id);
    return "Produto" + id + "deletado com sucesso!";
  }

  @PutMapping
  public Produto atualizar(@RequestBody Produto produto, @PathVariable Integer id){

    return produtoService.atualizar(id, produto);

  }
}
