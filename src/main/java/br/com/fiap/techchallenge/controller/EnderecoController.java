package br.com.fiap.techchallenge.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.techchallenge.domain.Endereco;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/enderecos")
public class EnderecoController {

  EnderecoController() {}

  @PostMapping
  public ResponseEntity<Endereco> endereco(@RequestBody @Valid Endereco requestEndereco) {
    var endereco = new Endereco(
      requestEndereco.getRua(),
      requestEndereco.getNumero(),
      requestEndereco.getBairro(),
      requestEndereco.getCidade(),
      requestEndereco.getEstado(),
      requestEndereco.getCep()
    );

    return ResponseEntity.status(HttpStatus.CREATED).body(endereco);
  }

}
