package com.estoque.estoque.repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.estoque.estoque.model.Produto;

@Repository
public class ProdutoRepository {

  // SIMULANDO UM BANCO DE DADOS
  private ArrayList<Produto> produtos = new ArrayList<Produto>();
  private Integer ultimoId = 0;

  /**
   * Retorna uma lista de produtos.
   *
   * @return
   */
  public List<Produto> obterTodos() {
    return produtos;
  }

  /**
   *
   *
   * @param id do produto localizado
   * @return Retorna um produto encontrado via ID
   */
  public Optional<Produto> obterPorId(Integer id) {
    return produtos
        .stream()
        .filter(produto -> produto.getId() == id)
        .findFirst();
  }

  /**
   * Metodo para add produtos na lista
   *
   * @param produto
   * @return Retorna o produto add na lista
   */
  public Produto adicionar(Produto produto) {

    ultimoId++;

    produto.setId(ultimoId);
    produtos.add(produto);

    return produto;
  }

  /**
   * Metodo para deletar os produtos
   *
   * @param id
   */
  public void deletar(Integer id) {

    produtos.removeIf(produto -> produto.getId() == id);

  }

  /**
   * Metodo para atualizar o produto
   *
   * @param produto atualizado
   * @return Caso o id do produto seja encontrado, irá retornar o produto
   *         atualizado
   */

  public Produto atualizar(Produto produto) {
    // encontrar um produto
    Optional<Produto> produtoEncontrado = obterPorId(produto.getId());

    // isEmpty = que é vazio/nulo nao encontrou nenhum produto com o id informado
    if (produtoEncontrado.isEmpty()) {
      throw new InputMismatchException("Produto nao encontrado");
    }
    // remover o produto antigo
    deletar(produto.getId());

    // adicionar um produto atualizado na lista
    produtos.add(produto);

    return produto;
  }
}
