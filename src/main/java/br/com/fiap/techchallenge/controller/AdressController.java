package br.com.fiap.techchallenge.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.techchallenge.domain.Adress;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/enderecos")
public class AdressController {

  AdressController() {}

  @PostMapping
  public ResponseEntity<Adress> adress(@RequestBody @Valid Adress requestAdress) {
    var adress = new Adress(
      requestAdress.getStreet(),
      requestAdress.getNumber(),
      requestAdress.getNeighborhood(),
      requestAdress.getCity(),
      requestAdress.getState()
    );

    return ResponseEntity.status(HttpStatus.CREATED).body(adress);
  }

  
}
