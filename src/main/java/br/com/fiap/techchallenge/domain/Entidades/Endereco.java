package br.com.fiap.techchallenge.domain.Entidades;

import br.com.fiap.techchallenge.View.Controller.DTO.EnderecoDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

import java.util.UUID;

@Entity
@Table()
public class Endereco {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @NotEmpty
  @Pattern(regexp = "\\d{5}-\\d{3}", message = "Deve estar no formato 00000-000")
  @Column(length = 9, nullable = false)
  private String cep;

  @NotEmpty
  @Column(length = 20, nullable = false)
  private String estado;

  @NotEmpty
  @Column(nullable = false, length = 255)
  private String rua;

  @NotEmpty
  @Column(nullable = false, length = 10)
  private String numero;

  @NotEmpty
  @Column(nullable = false, length = 100)
  private String bairro;

  @NotEmpty
  @Column(length = 50, nullable = false)
  private String cidade;
  
  public Endereco(String rua, String numero, String bairro, String cidade, String estado, String cep) {
    this.rua = rua;
    this.numero = numero;
    this.bairro = bairro;
    this.cidade = cidade;
    this.estado = estado;
    this.cep = cep;
  }

  public Endereco() {}

  public UUID getId() {
    return id;
  }

  public String getRua() {
    return this.rua;
  }

  public String getNumero() {
    return this.numero;
  }

  public String getBairro() {
    return this.bairro;
  }

  public String getCidade() {
    return this.cidade;
  }

  public String getEstado() {
    return this.estado;
  }

  public String getCep() {
    return this.cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public void setRua(String rua) {
    this.rua = rua;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }
}
