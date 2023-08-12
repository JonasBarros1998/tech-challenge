package br.com.fiap.techchallenge.Aplicacao.Entidades.ValueObjects;

import jakarta.validation.constraints.NotEmpty;

public class Numero {

	@NotEmpty
	private final String numero;

	public Numero(String numero) {
		this.numero = numero;
	}

	public String getNumero() {
		return numero;
	}
}
