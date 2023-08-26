package br.com.fiap.techchallenge.domain.Entidades;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "eletrodomesticos")
public class Eletrodomestico {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 100)
    private String modelo;

    @Column(nullable = false)
    private BigDecimal potencia;

    @Column(nullable = false)
    private BigDecimal volts;

    @Column(nullable = false, length = 50)
    private String marca;

    @Embedded
    private EficienciaEnergetica eficienciaEnergetica;

    @Column(nullable = false, insertable = true)
    private final LocalDate dataDeCadastro = LocalDate.now();

    public Eletrodomestico() {}

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
