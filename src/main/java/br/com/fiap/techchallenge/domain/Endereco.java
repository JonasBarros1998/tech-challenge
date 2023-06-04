package br.com.fiap.techchallenge.domain;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public class Endereco {

  @NotEmpty
  @Pattern(regexp = "\\d{5}-\\d{3}", message = "the format cep should be 00000-000")
  private final String cep;

  @NotEmpty
  private final String rua;

  @NotEmpty
  private final String numero;

  @NotEmpty
  private final String bairro;

  @NotEmpty
  private final String cidade;

  @NotEmpty
  private final String estado;
  
  public Endereco(String rua, String numero, String bairro, String cidade, String estado, String cep) {
    this.rua = rua;
    this.numero = numero;
    this.bairro = bairro;
    this.cidade = cidade;
    this.estado = estado;
    this.cep = cep;
  }

  public String getRua() {
    return rua;
  }

  public String getNumero() {
    return numero;
  }

  public String getBairro() {
    return bairro;
  }

  public String getCidade() {
    return cidade;
  }

  public String getEstado() {
    return estado;
  }

  public String getCep() {
    return cep;
  }
  
}
