package br.com.fiap.techchallenge.domain.Entidades;

import br.com.fiap.techchallenge.domain.Entidades.ValueObjects.*;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table()
public class Endereco {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Embedded
  private CEP cep;

  @Embedded
  private Estado estado;

  @Embedded
  private Rua rua;

  @Embedded
  private Numero numero;

  @Embedded
  private Bairro bairro;

  @Embedded
  private Cidade cidade;
  
  public Endereco(Rua rua, Numero numero, Bairro bairro, Cidade cidade, Estado estado, CEP cep) {
    this.rua = rua;
    this.numero = numero;
    this.bairro = bairro;
    this.cidade = cidade;
    this.estado = estado;
    this.cep = cep;
  }

  public Endereco() {}

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
