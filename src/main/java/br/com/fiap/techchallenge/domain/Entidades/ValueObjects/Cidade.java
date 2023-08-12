package br.com.fiap.techchallenge.domain.Entidades.ValueObjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotEmpty;

@Embeddable
public class Cidade {

	@NotEmpty
	@Column(length = 50, nullable = false)
	private String cidade;

	public Cidade(String cidade) {
		this.cidade = cidade;
	}

	public Cidade() {}

	public String getCidade() {
		return cidade;
	}
}
