package br.com.fiap.techchallenge.controller;

import br.com.fiap.techchallenge.domain.Person;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/people")
public class PersonController {

    @PostMapping
    public ResponseEntity<Person> person(@RequestBody @Valid Person personRequest) {
        Person person = new Person(
                personRequest.getName(),
                personRequest.getDate(),
                personRequest.getSexualPreference()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(person);
    }



}
