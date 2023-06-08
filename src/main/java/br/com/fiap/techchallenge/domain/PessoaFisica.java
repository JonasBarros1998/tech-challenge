package br.com.fiap.techchallenge.domain;

import jakarta.annotation.Nullable;
import jakarta.validation.Valid;

import java.time.LocalDate;
import java.util.ArrayList;

public class PessoaFisica extends Pessoa {


	@Valid
	@Nullable
	private ArrayList<Dependentes> dependentes;

	PessoaFisica() {}

	public PessoaFisica(String name, LocalDate nascimento, String genero, String cpf, ArrayList<Dependentes> dependentes) {
		super(name, nascimento, genero, cpf);
		this.dependentes = dependentes;
	}

	public ArrayList<Dependentes> getDependentes() {
		return dependentes;
	}

}
