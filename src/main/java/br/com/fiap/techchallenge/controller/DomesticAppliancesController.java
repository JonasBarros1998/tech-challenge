package br.com.fiap.techchallenge.controller;

import br.com.fiap.techchallenge.domain.DomesticAppliances;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eletrodomesticos")
public class DomesticAppliancesController {

    @PostMapping
    ResponseEntity<DomesticAppliances> domesticApplience(@RequestBody @Valid DomesticAppliances domesticApplianceRequest) {
        DomesticAppliances domesticAppliances = new DomesticAppliances(
                domesticApplianceRequest.getName(),
                domesticApplianceRequest.getModel(),
                domesticApplianceRequest.getPower(),
                domesticApplianceRequest.getVolts(),
                domesticApplianceRequest.getBrand(),
                domesticApplianceRequest.getEnergyEfficiency());

        return ResponseEntity.status(HttpStatus.CREATED).body(domesticAppliances);

    }


}
