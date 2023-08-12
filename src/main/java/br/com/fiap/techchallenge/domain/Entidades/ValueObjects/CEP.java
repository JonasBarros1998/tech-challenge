package br.com.fiap.techchallenge.domain.Entidades.ValueObjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@Embeddable
public class CEP {

	@NotEmpty
	@Pattern(regexp = "\\d{5}-\\d{3}", message = "Deve estar no formato 00000-000")
	@Column(length = 9, nullable = false)
	private String cep;

	public CEP(String cep) {
		this.cep = cep;
	}

	public CEP() {}

	public String getCep() {
		return cep;
	}

}
