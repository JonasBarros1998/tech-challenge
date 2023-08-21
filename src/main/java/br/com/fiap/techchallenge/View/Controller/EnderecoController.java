package br.com.fiap.techchallenge.View.Controller;

import br.com.fiap.techchallenge.Aplicacao.Endereco.GerenciarEnderecos;
import br.com.fiap.techchallenge.View.Controller.DTO.EnderecoDTO;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.fiap.techchallenge.domain.Entidades.Endereco;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/enderecos")
public class EnderecoController {

  GerenciarEnderecos gerenciarEnderecos;

  @Autowired
  EnderecoController(GerenciarEnderecos gerenciarEnderecos) {
    this.gerenciarEnderecos = gerenciarEnderecos;
  }

  @PostMapping
  public ResponseEntity<EnderecoDTO> endereco(@RequestBody @Valid EnderecoForm requestEndereco) {
    var enderecoDTO = this.gerenciarEnderecos.salvar(requestEndereco);
    return ResponseEntity.status(HttpStatus.CREATED).body(enderecoDTO);
  }

  @GetMapping
  public ResponseEntity<List<EnderecoDTO>> endereco() {
    return ResponseEntity.status(HttpStatus.CREATED).body(gerenciarEnderecos.listar());
  }

  @PutMapping("/{id}")
  public ResponseEntity<EnderecoDTO> endereco(@PathVariable UUID id, @RequestBody @Valid EnderecoForm requestEndereco) {
    EnderecoDTO enderecoDTO = this.gerenciarEnderecos.atualizar(id, requestEndereco);
    return ResponseEntity.status(HttpStatus.CREATED).body(enderecoDTO);
  }

  /*
  @DeleteMapping("/{id}")
  public ResponseEntity<EnderecoDTO> endereco(@PathVariable String id) {

    return ResponseEntity.status(HttpStatus.CREATED).body(requestEndereco);
  }*/
}
