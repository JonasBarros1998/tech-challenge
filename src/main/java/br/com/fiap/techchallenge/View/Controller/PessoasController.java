package br.com.fiap.techchallenge.View.Controller;

import br.com.fiap.techchallenge.Aplicacao.GerenciarPessoas;
import br.com.fiap.techchallenge.View.Controller.DTO.PessoaDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pessoas")
public class PessoasController {

    GerenciarPessoas gerenciarPessoas;

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
        PessoaDTO pessoa = this.gerenciarPessoas.editar(pessoaDTO, cpf);
        return ResponseEntity.status(HttpStatus.OK).body(pessoa);
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<PessoaDTO> editar(@PathVariable String cpf) {
        this.gerenciarPessoas.remover(cpf);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping(params = "nome")
    public ResponseEntity<List<PessoaDTO>> pesquisarPorNome(@RequestParam(name = "nome") String nome) {
        List<PessoaDTO> pessoas = this.gerenciarPessoas.pesquisarPorNome(nome);
        return ResponseEntity.status(HttpStatus.OK).body(pessoas);
    }

    @GetMapping(params = "genero")
    public ResponseEntity<List<PessoaDTO>> pesquisarPorGenero(@RequestParam(name = "genero") String genero) {
        List<PessoaDTO> pessoas = this.gerenciarPessoas.pesquisarPorGenero(genero);
        return ResponseEntity.status(HttpStatus.OK).body(pessoas);
    }
}
