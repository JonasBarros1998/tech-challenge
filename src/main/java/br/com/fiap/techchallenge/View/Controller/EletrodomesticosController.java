package br.com.fiap.techchallenge.View.Controller;

import br.com.fiap.techchallenge.domain.Eletrodomestico;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/eletrodomesticos")
public class EletrodomesticosController {

    @PostMapping
    ResponseEntity<Object> eletrodomesticos(@RequestBody @Valid Eletrodomestico eletrodomesticosRequest) {
        var eletrodomestico = new Eletrodomestico(
            eletrodomesticosRequest.getNome(),
            eletrodomesticosRequest.getModelo(),
            eletrodomesticosRequest.getPotencia(),
            eletrodomesticosRequest.getVolts(),
            eletrodomesticosRequest.getMarca(),
            eletrodomesticosRequest.getEficienciaEnergetica());

        return ResponseEntity.status(HttpStatus.OK).body(eletrodomesticosRequest);
    }

}
