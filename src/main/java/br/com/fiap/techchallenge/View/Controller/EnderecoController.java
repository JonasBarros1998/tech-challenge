package br.com.fiap.techchallenge.View.Controller;

import br.com.fiap.techchallenge.Aplicacao.GerenciarEnderecos;
import br.com.fiap.techchallenge.Dominio.Entidades.Cliente;
import br.com.fiap.techchallenge.Dominio.Entidades.Endereco;
import br.com.fiap.techchallenge.Dominio.Entidades.Pessoa;
import br.com.fiap.techchallenge.View.Controller.DTO.EnderecoDTO;
import br.com.fiap.techchallenge.View.Controller.DTO.PessoaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Objects;
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
  public ResponseEntity<List<EnderecoDTO>> listar() {
    return ResponseEntity.status(HttpStatus.CREATED).body(gerenciarEnderecos.listar());
  }

  @GetMapping(params = "bairro")
  public ResponseEntity<List<EnderecoDTO>> pesquisarPorBairro(@RequestParam(name = "bairro") String bairro) {
    var enderecosDTO = this.gerenciarEnderecos.pesquisarPorBairro(bairro);
    return ResponseEntity.status(HttpStatus.OK).body(enderecosDTO);
  }

  @GetMapping(params = "cidade")
  public ResponseEntity<List<EnderecoDTO>> pesquisarPorCidade(@RequestParam(name = "cidade") String cidade) {
    var enderecosDTO = this.gerenciarEnderecos.pesquisarPorCidade(cidade);
    return ResponseEntity.status(HttpStatus.OK).body(enderecosDTO);
  }

  @GetMapping(params = "estado")
  public ResponseEntity<List<EnderecoDTO>> pesquisarPorEstado(@RequestParam(name = "estado") String estado) {
    var enderecosDTO = this.gerenciarEnderecos.pesquisarPorEstado(estado);
    return ResponseEntity.status(HttpStatus.OK).body(enderecosDTO);
  }

  @GetMapping(params = "rua")
  public ResponseEntity<List<EnderecoDTO>> pesquisarPorRua(@RequestParam(name = "rua") String rua) {
    var enderecosDTO = this.gerenciarEnderecos.pesquisarPorRua(rua);
    return ResponseEntity.status(HttpStatus.OK).body(enderecosDTO);
  }

  @GetMapping("/{id}")
  public ResponseEntity<List<EnderecoDTO>> editar(@PathVariable UUID id) {
    List<EnderecoDTO> enderecoDTO = this.gerenciarEnderecos.pesquisarPor(id);
    return ResponseEntity.status(HttpStatus.OK).body(enderecoDTO);
  }

  @PutMapping("/{id}")
  public ResponseEntity<EnderecoDTO> editar(@PathVariable UUID id, @RequestBody @Valid EnderecoDTO requestEndereco) {
    EnderecoDTO enderecoSaida = this.gerenciarEnderecos.atualizar(id, requestEndereco);
    return ResponseEntity.status(HttpStatus.CREATED).body(enderecoSaida);
  }

  @GetMapping(params = "cpf")
  public ResponseEntity<List<EnderecoDTO>> pesquisarEnderecoPorNomeDaPessoa(@RequestParam("cpf") String cpf) {
    var enderecosPorNome = this.gerenciarEnderecos.pesquisarEnderecoPorCpf(cpf);
    return ResponseEntity.status(HttpStatus.OK).body(enderecosPorNome);
  }

  @GetMapping(value = "/{enderecoID}/pessoas")
  public ResponseEntity<List<PessoaDTO>> pesquisarPorUsuariosPorIdDoEndereco(@PathVariable("enderecoID") UUID enderecoID) {
    var enderecos = this.gerenciarEnderecos.pesquisarEnderecoPorPessoa(enderecoID);
    return ResponseEntity.status(HttpStatus.OK).body(enderecos);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity remover(@PathVariable UUID id) {
    this.gerenciarEnderecos.remover(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

}
