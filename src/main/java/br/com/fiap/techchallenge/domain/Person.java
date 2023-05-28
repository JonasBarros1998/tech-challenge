package br.com.fiap.techchallenge.domain;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public class Person {

    @NotEmpty
    private final String name;

    @Past
    private final LocalDate date;

    @NotEmpty
    private final String sexualPreference;

    public Person(String name, LocalDate date, String sexualPreference) {
        this.name = name;
        this.date = date;
        this.sexualPreference = sexualPreference;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getSexualPreference() {
        return sexualPreference;
    }

}
