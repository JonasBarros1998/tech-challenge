package br.com.fiap.techchallenge.domain.Entidades.ValueObjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotEmpty;

@Embeddable
public class Numero {

	@NotEmpty
	@Column(nullable = false, length = 10)
	private String numero;

	public Numero(String numero) {
		this.numero = numero;
	}

	public  Numero() {}

	public String getNumero() {
		return numero;
	}
}
