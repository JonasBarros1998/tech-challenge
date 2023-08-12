package br.com.fiap.techchallenge.View.Controller;

import br.com.fiap.techchallenge.View.Controller.DTO.EnderecoDTO;
import br.com.fiap.techchallenge.domain.Entidades.ValueObjects.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.techchallenge.domain.Entidades.Endereco;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/enderecos")
public class EnderecoController {

  EnderecoController() {}

  @PostMapping
  public ResponseEntity<EnderecoDTO> endereco(@RequestBody @Valid EnderecoDTO requestEndereco) {
    var endereco = new Endereco(
      new Rua(requestEndereco.rua()),
      new Numero(requestEndereco.numero()),
      new Bairro(requestEndereco.bairro()),
      new Cidade(requestEndereco.cidade()),
      new Estado(requestEndereco.estado()),
      new CEP(requestEndereco.cep())
    );

    return ResponseEntity.status(HttpStatus.CREATED).body(requestEndereco);
  }

}
