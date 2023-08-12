package br.com.fiap.techchallenge.Aplicacao.Entidades.ValueObjects;

import jakarta.validation.constraints.NotEmpty;

public class Bairro {

	@NotEmpty
	public final String bairro;

	public Bairro(String bairro) {
		this.bairro = bairro;
	}

	public String getBairro() {
		return bairro;
	}

}
