package br.com.fiap.techchallenge.View.Controller.Form;

import br.com.fiap.techchallenge.domain.Entidades.Cliente;

public class GrauParentesco {
	private Cliente superior;
	private Cliente dependente;
	private String parentesco;

	public GrauParentesco() {}

	public GrauParentesco(Cliente superior, Cliente dependente, String parentesco) {
		this.superior = superior;
		this.dependente = dependente;
		this.parentesco = parentesco;
	}

	public Cliente getSuperior() {
		return this.superior;
	}

	public Cliente getDependente() {
		return this.dependente;
	}

	public String getParentesco() {
		return parentesco;
	}

}

