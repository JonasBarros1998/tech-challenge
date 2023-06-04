package br.com.fiap.techchallenge.domain;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public class Pessoa {

    @NotEmpty
    @CPF
    private final String cpf;

    @NotEmpty
    private final String nome;

    @Past
    @NotEmpty
    private final LocalDate dataDeNascimento;

    @NotEmpty
    private final String genero;

    public Pessoa(String name, LocalDate dataDeNascimento, String genero, String cpf) {
        this.nome = name;
        this.dataDeNascimento = dataDeNascimento;
        this.genero = genero;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public String getGenero() {
        return genero;
    }

    public String getCpf() {
        return cpf;
    }

}
