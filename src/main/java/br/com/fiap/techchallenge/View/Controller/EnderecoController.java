package br.com.fiap.techchallenge.View.Controller;

import br.com.fiap.techchallenge.Aplicacao.GerenciarEnderecos;
import br.com.fiap.techchallenge.View.Controller.DTO.EnderecoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
  public ResponseEntity<EnderecoDTO> endereco(@RequestBody @Valid EnderecoDTO requestEndereco) {
    var enderecoDTO = this.gerenciarEnderecos.salvar(requestEndereco);
    return ResponseEntity.status(HttpStatus.CREATED).body(enderecoDTO);
  }

  @GetMapping
  public ResponseEntity<List<EnderecoDTO>> endereco() {
    return ResponseEntity.status(HttpStatus.CREATED).body(gerenciarEnderecos.listar());
  }

  @GetMapping(params = "bairro")
  public ResponseEntity<List<EnderecoDTO>> pesquisarPorBairro(@RequestParam(name = "bairro") String bairro) {
    var enderecosDTO = this.gerenciarEnderecos.pesquisarPor(bairro, "bairro");
    return ResponseEntity.status(HttpStatus.OK).body(enderecosDTO);
  }

  @GetMapping(params = "cidade")
  public ResponseEntity<List<EnderecoDTO>> pesquisarPorCidade(@RequestParam(name = "cidade") String cidade) {
    var enderecosDTO = this.gerenciarEnderecos.pesquisarPor(cidade, "cidade");
    return ResponseEntity.status(HttpStatus.OK).body(enderecosDTO);
  }

  @GetMapping(params = "estado")
  public ResponseEntity<List<EnderecoDTO>> pesquisarPorEstado(@RequestParam(name = "estado") String estado) {
    var enderecosDTO = this.gerenciarEnderecos.pesquisarPor(estado, "estado");
    return ResponseEntity.status(HttpStatus.OK).body(enderecosDTO);
  }

  @GetMapping(params = "rua")
  public ResponseEntity<List<EnderecoDTO>> pesquisarPorRua(@RequestParam(name = "rua") String rua) {
    var enderecosDTO = this.gerenciarEnderecos.pesquisarPor(rua, "rua");
    return ResponseEntity.status(HttpStatus.OK).body(enderecosDTO);
  }

  @GetMapping("/{id}")
  public ResponseEntity<List<EnderecoDTO>> editar(@PathVariable UUID id) {
    List<EnderecoDTO> enderecoDTO = this.gerenciarEnderecos.pesquisarPor(id);
    return ResponseEntity.status(HttpStatus.OK).body(enderecoDTO);
  }

  @PutMapping("/{id}")
  public ResponseEntity<EnderecoDTO> editar(@PathVariable UUID id, @RequestBody @Valid EnderecoDTO requestEndereco) {
    EnderecoDTO enderecoDTO = this.gerenciarEnderecos.atualizar(id, requestEndereco);
    return ResponseEntity.status(HttpStatus.CREATED).body(enderecoDTO);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity remover(@PathVariable UUID id) {
    this.gerenciarEnderecos.remover(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }


}
