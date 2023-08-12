package br.com.fiap.techchallenge.domain.Entidades.ValueObjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotEmpty;

@Embeddable
public class Bairro {

	@NotEmpty
	@Column(nullable = false, length = 100)
	public String bairro;

	public Bairro(String bairro) {
		this.bairro = bairro;
	}

	public Bairro(){}

	public String getBairro() {
		return bairro;
	}

}
