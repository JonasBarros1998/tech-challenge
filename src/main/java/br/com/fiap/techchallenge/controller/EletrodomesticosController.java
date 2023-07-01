package br.com.fiap.techchallenge.controller;

import br.com.fiap.techchallenge.domain.Eletrodomestico;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/eletrodomesticos")
public class EletrodomesticosController {

    @PostMapping
    ResponseEntity<Eletrodomestico> eletrodomesticos(@RequestBody @Valid Eletrodomestico eletrodomesticosRequest) {
        var eletrodomestico = new Eletrodomestico(
            eletrodomesticosRequest.getNome(),
            eletrodomesticosRequest.getModelo(),
            eletrodomesticosRequest.getPotencia(),
            eletrodomesticosRequest.getVolts(),
            eletrodomesticosRequest.getMarca(),
            eletrodomesticosRequest.getEficienciaEnergetica());

        return ResponseEntity.status(HttpStatus.CREATED).body(eletrodomestico);

    }

}
