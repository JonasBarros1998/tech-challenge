package br.com.fiap.techchallenge.Aplicacao.Entidades.ValueObjects;

import jakarta.validation.constraints.NotEmpty;

public class Rua {

	@NotEmpty
	private final String rua;

	public Rua(String rua) {
		this.rua = rua;
	}

	public String getRua() {
		return rua;
	}
}
