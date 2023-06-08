package br.com.fiap.techchallenge.controller;

import br.com.fiap.techchallenge.domain.PessoaFisica;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

    @PostMapping
    public ResponseEntity<PessoaFisica> pessoa(@RequestBody @Valid PessoaFisica pessoaRequest) {

        var pessoa = new PessoaFisica(
          pessoaRequest.getNome(),
          pessoaRequest.getNascimento(),
          pessoaRequest.getGenero(),
          pessoaRequest.getCpf(),
          pessoaRequest.getDependentes()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(pessoa);
    }

}
