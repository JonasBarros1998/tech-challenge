package br.com.fiap.techchallenge.Aplicacao.Entidades.ValueObjects;

import jakarta.validation.constraints.NotEmpty;

public class Estado {

	@NotEmpty
	private final String estado;

	@NotEmpty
	public Estado(String estado) {
		this.estado = estado;
	}

	public String getEstado() {
		return estado;
	}
}
