package br.com.fiap.techchallenge.domain.Entidades.ValueObjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotEmpty;

@Embeddable
public class Rua {

	@NotEmpty
	@Column(nullable = false, length = 255)
	private String rua;

	public Rua(String rua) {
		this.rua = rua;
	}

	public Rua() {}

	public String getRua() {
		return rua;
	}
}
