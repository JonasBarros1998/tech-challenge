package br.com.fiap.techchallenge.Aplicacao.Entidades.ValueObjects;

import jakarta.validation.constraints.NotEmpty;

public class Cidade {

	@NotEmpty
	private final String cidade;

	public Cidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCidade() {
		return cidade;
	}
}
