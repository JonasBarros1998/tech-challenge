package br.com.fiap.techchallenge.domain.Entidades.ValueObjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotEmpty;

@Embeddable
public class Estado {

	@NotEmpty
	@Column(length = 20, nullable = false)
	private String estado;

	@NotEmpty
	public Estado(String estado) {
		this.estado = estado;
	}

	public Estado() {}

	public String getEstado() {
		return estado;
	}
}
