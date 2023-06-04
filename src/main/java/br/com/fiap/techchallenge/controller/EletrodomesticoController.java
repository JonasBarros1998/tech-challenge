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
public class EletrodomesticoController {

    @PostMapping
    ResponseEntity<Eletrodomestico> domesticApplience(@RequestBody @Valid Eletrodomestico domesticApplianceRequest) {
        Eletrodomestico domesticAppliances = new Eletrodomestico(
            domesticApplianceRequest.getNome(),
            domesticApplianceRequest.getModelo(),
            domesticApplianceRequest.getPotencia(),
            domesticApplianceRequest.getVolts(),
            domesticApplianceRequest.getMarca(),
            domesticApplianceRequest.getEficienciaEnergetica());

        return ResponseEntity.status(HttpStatus.CREATED).body(domesticAppliances);

    }

}
