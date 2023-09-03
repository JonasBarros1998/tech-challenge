package br.com.fiap.techchallenge.Dominio.Entidades;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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

    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name = "eletrodomesticos_usuarios",
      joinColumns = @JoinColumn(name = "eletrodomestico_id"),
      inverseJoinColumns = @JoinColumn(name = "usuario_id"))
    private List<Usuario> usuario = new ArrayList<>();

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

    public Eletrodomestico(
      String nome,
      String modelo,
      BigDecimal potencia,
      BigDecimal volts,
      String marca,
      EficienciaEnergetica eficienciaEnergetica,
      List<Usuario> usuario) {
        this.nome = nome;
        this.modelo = modelo;
        this.potencia = potencia;
        this.volts = volts;
        this.marca = marca;
        this.eficienciaEnergetica = eficienciaEnergetica;
        this.usuario = usuario;
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

    public List<Usuario> getUsuario() {
        return this.usuario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPotencia(BigDecimal potencia) {
        this.potencia = potencia;
    }

    public void setVolts(BigDecimal volts) {
        this.volts = volts;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setEficienciaEnergetica(EficienciaEnergetica eficienciaEnergetica) {
        this.eficienciaEnergetica = eficienciaEnergetica;
    }

    public void addUsuario(Usuario usuario) {
        this.usuario.add(usuario);
    }
}
