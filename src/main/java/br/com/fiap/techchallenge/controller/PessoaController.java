package br.com.fiap.techchallenge.controller;

import br.com.fiap.techchallenge.domain.Pessoa;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

    @PostMapping
    public ResponseEntity<Pessoa> person(@RequestBody @Valid Pessoa pessoaRequest) {
        Pessoa person = new Pessoa(
          pessoaRequest.getNome(),
          pessoaRequest.getDataDeNascimento(),
          pessoaRequest.getGenero(),
          pessoaRequest.getCpf()

        );

        return ResponseEntity.status(HttpStatus.CREATED).body(person);
    }



}
