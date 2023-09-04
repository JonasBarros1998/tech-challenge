package br.com.fiap.techchallenge.Dominio.Entidades;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "relacionamento")
public class Dependente{

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	UUID id;

	@ManyToOne
	@JoinColumn(name = "superior")
	Cliente superior;

	@ManyToOne
	@JoinColumn(name = "dependente")
	Cliente dependente;

	@Column(nullable = false, length = 50, name = "parentesco")
	String parentesco;

	public Dependente() {}

	public Dependente(String parentesco, Cliente superior, Cliente dependente) {
		this.parentesco = parentesco;
		this.dependente = dependente;
		this.superior = superior;
	}

	public String getParentesco() {
		return parentesco;
	}

	public void setPessoaId1(Cliente superior) {
		this.superior = superior;
	}

	public void setPessoaId2(Cliente dependente) {
		this.dependente = dependente;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}
}
