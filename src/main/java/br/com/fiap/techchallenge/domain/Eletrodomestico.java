package br.com.fiap.techchallenge.domain;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Eletrodomestico {

    @NotEmpty
    private final String nome;

    @NotEmpty
    private final String modelo;

    @DecimalMin(value = "0")
    private final BigDecimal potencia;

    @DecimalMin(value = "0")
    private final BigDecimal volts;

    @NotEmpty
    private final String marca;

    @Valid
    private final EficienciaEnergetica eficienciaEnergetica;

    private final LocalDate dataDeCadastro = LocalDate.now();

    public Eletrodomestico(
            String nome,
            String modelo,
            BigDecimal potencia,
            BigDecimal volts,
            String marca,
            EficienciaEnergetica eficienciaEnergetica
    ) {
        this.nome = nome;
        this.modelo = modelo;
        this.potencia = potencia;
        this.volts = volts;
        this.marca = marca;
        this.eficienciaEnergetica = eficienciaEnergetica;
    }

    public String getNome() {
        return nome;
    }

    public String getModelo() {
        return modelo;
    }

    public BigDecimal getPotencia() {
        return potencia;
    }

    public BigDecimal getVolts() {
        return volts;
    }

    public String getMarca() {
        return marca;
    }

    public EficienciaEnergetica getEficienciaEnergetica() {
        return eficienciaEnergetica;
    }

    public String getDataDeCadastro() {
        return dataDeCadastro.toString();
    }

}
