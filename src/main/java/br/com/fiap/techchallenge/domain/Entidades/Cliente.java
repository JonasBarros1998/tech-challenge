package br.com.fiap.techchallenge.domain.Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "pessoas")
public class Cliente extends Pessoa {
	/*
	@Valid
	@Nullable
	private ArrayList<Dependentes> dependentes;*/

	@Column(insertable = true)
	private final LocalDate dataDeCadastro = LocalDate.now();

	public Cliente() {}

	public Cliente(String name, LocalDate nascimento, String genero, String cpf/*ArrayList<Dependentes> dependentes*/) {
		super(name, nascimento, genero, cpf);
		//this.dependentes = dependentes;
	}

	/*public ArrayList<Dependentes> getDependentes() {
		return dependentes;
	}

	public LocalDate getDataDeCadastro() {
		return dataDeCadastro;
	}*/
}
