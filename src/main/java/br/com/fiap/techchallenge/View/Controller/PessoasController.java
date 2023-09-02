package br.com.fiap.techchallenge.View.Controller;

import br.com.fiap.techchallenge.Aplicacao.GerenciarPessoas;
import br.com.fiap.techchallenge.Infra.Repository.DependenteRepository;
import br.com.fiap.techchallenge.View.Controller.DTO.PessoaDTO;
import br.com.fiap.techchallenge.Dominio.Entidades.Cliente;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/pessoas")
public class PessoasController {

    GerenciarPessoas gerenciarPessoas;

    @Autowired
    DependenteRepository dependenteRepository;

    @Autowired
    PessoasController(GerenciarPessoas gerenciarPessoas) {
        this.gerenciarPessoas = gerenciarPessoas;
    }

    @PostMapping
    public ResponseEntity<PessoaDTO> salvar(@RequestBody @Valid PessoaDTO clienteRequest) {
        PessoaDTO pessoaDTO = this.gerenciarPessoas.salvar(clienteRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaDTO);
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<PessoaDTO> editar(@PathVariable String cpf, @RequestBody @Valid PessoaDTO pessoaDTO) {
        PessoaDTO pessoa = this.gerenciarPessoas.editarPessoa(pessoaDTO, cpf);
        return ResponseEntity.status(HttpStatus.OK).body(pessoa);
    }

    @PutMapping("/dependente/{idDependente}/superior")
    public ResponseEntity<PessoaDTO> alterarDependenteDeSuperior(
      @PathVariable UUID idDependente,
      @RequestBody @Valid PessoaDTO pessoaDTO
    ) {
        PessoaDTO pessoa = this.gerenciarPessoas.alterarRelacionamento(idDependente, pessoaDTO);
        return ResponseEntity.status(HttpStatus.OK).body(pessoa);
    }

    @GetMapping("/{cpf}/dependentes")
    public ResponseEntity<List<Cliente>> pesquisarPorDependentes(@PathVariable String cpf) {
        var pessoas = this.gerenciarPessoas.pesquisarPorDependentes(cpf);
        return ResponseEntity.status(HttpStatus.OK).body(pessoas);
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<PessoaDTO> editar(@PathVariable String cpf) {
        this.gerenciarPessoas.remover(cpf);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping(params = "nome")
    public ResponseEntity<List<PessoaDTO>> pesquisarPorNome(@RequestParam(name = "nome") String nome) {
        var pessoas = this.gerenciarPessoas.pesquisarPorNome(nome);
        return ResponseEntity.status(HttpStatus.OK).body(pessoas);
    }

    @GetMapping(params = "genero")
    public ResponseEntity<List<PessoaDTO>> pesquisarPorGenero(@RequestParam(name = "genero") String genero) {
        List<PessoaDTO> pessoas = this.gerenciarPessoas.pesquisarPorGenero(genero);
        return ResponseEntity.status(HttpStatus.OK).body(pessoas);
    }

    @GetMapping(value="/{cpf}/parentesco", params = {"tipo"})
    public ResponseEntity<List<Cliente>> pesquisarPorParentesco(
      @PathVariable String cpf,
      @RequestParam(name = "tipo") String tipo
    ) {
        List<Cliente> pessoas = this.gerenciarPessoas.pesquisarPorParentesco(cpf, tipo);
        return ResponseEntity.status(HttpStatus.OK).body(pessoas);
    }

}
