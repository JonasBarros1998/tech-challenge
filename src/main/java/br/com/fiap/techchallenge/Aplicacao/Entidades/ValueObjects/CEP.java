package br.com.fiap.techchallenge.Aplicacao.Entidades.ValueObjects;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public class CEP {

	@NotEmpty
	@Pattern(regexp = "\\d{5}-\\d{3}", message = "Deve estar no formato 00000-000")
	private final String cep;

	public CEP(String cep) {
		this.cep = cep;
	}

	public String getCep() {
		return cep;
	}

}
