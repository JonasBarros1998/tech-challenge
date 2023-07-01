package br.com.fiap.techchallenge.controller;

import br.com.fiap.techchallenge.domain.Cliente;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pessoas")
public class PessoasController {

    @PostMapping
    public ResponseEntity<Cliente> pessoa(@RequestBody @Valid Cliente pessoasRequest) {

        var cliente = new Cliente(
          pessoasRequest.getNome(),
          pessoasRequest.getNascimento(),
          pessoasRequest.getGenero(),
          pessoasRequest.getCpf(),
          pessoasRequest.getDependentes()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

}
