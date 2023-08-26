package br.com.fiap.techchallenge.domain.Entidades;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Pessoa {

    @Id
    private String cpf;

    @Column(length = 255, nullable = false)
    private String nome;

    @Column(nullable = false)
    private LocalDate nascimento;

    @Column(length = 50, nullable = false)
    private String genero;

    public Pessoa() {}

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

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
