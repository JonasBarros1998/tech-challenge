package br.com.fiap.techchallenge.Aplicacao.Entidades;

import br.com.fiap.techchallenge.Aplicacao.Entidades.ValueObjects.*;

public class Endereco {

  private final CEP cep;

  private final Estado estado;

  private final Rua rua;

  private final Numero numero;

  private final Bairro bairro;

  private final Cidade cidade;
  
  public Endereco(Rua rua, Numero numero, Bairro bairro, Cidade cidade, Estado estado, CEP cep) {
    this.rua = rua;
    this.numero = numero;
    this.bairro = bairro;
    this.cidade = cidade;
    this.estado = estado;
    this.cep = cep;
  }

  public Rua getRua() {
    return rua;
  }

  public Numero getNumero() {
    return numero;
  }

  public Bairro getBairro() {
    return bairro;
  }

  public Cidade getCidade() {
    return cidade;
  }

  public Estado getEstado() {
    return estado;
  }

  public CEP getCep() {
    return cep;
  }
  
}
