package br.com.fiap.techchallenge.domain;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public abstract class Pessoa {

    @NotEmpty
    @CPF
    private String cpf;

    @NotEmpty
    private String nome;

    @Past
    @NotNull
    //@NotEmpty
    private LocalDate nascimento;

    @NotEmpty
    private String genero;

    Pessoa() {}

    public Pessoa(String name, LocalDate nascimento, String genero, String cpf) {
        this.nome = name;
        this.nascimento = nascimento;
        this.genero = genero;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public String getGenero() {
        return genero;
    }

    public String getCpf() {
        return cpf;
    }



}
