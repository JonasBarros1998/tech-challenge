package br.com.fiap.techchallenge.controller;

import br.com.fiap.techchallenge.domain.Cliente;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pessoas")
public class ClienteController {

    @PostMapping
    public ResponseEntity<Cliente> pessoa(@RequestBody @Valid Cliente pessoaRequest) {

        var cliente = new Cliente(
          pessoaRequest.getNome(),
          pessoaRequest.getNascimento(),
          pessoaRequest.getGenero(),
          pessoaRequest.getCpf(),
          pessoaRequest.getDependentes()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

}
