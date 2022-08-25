package com.estoque.estoque.model;

public class Produto {

  // #region Atributos
  private Integer id;

  private String nome;

  private Integer quatidade;

  private Double valor;

  private String observacoes;

  public Integer getId() {
    return id;
    // #endregion
  }

  // #region Gett and Setters
  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Integer getQuatidade() {
    return quatidade;
  }

  public void setQuatidade(Integer quatidade) {
    this.quatidade = quatidade;
  }

  public Double getValor() {
    return valor;
  }

  public void setValor(Double valor) {
    this.valor = valor;
  }

  public String getObservacoes() {
    return observacoes;
  }

  public void setObservacoes(String observacoes) {
    this.observacoes = observacoes;
  }
  // #endregion
}
