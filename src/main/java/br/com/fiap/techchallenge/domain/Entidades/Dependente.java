package br.com.fiap.techchallenge.domain.Entidades;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "relacionamento")
public class Dependente {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	UUID id;

	@ManyToOne
	@JoinColumn(name = "pessoa_id_1")
	Cliente pessoaId1;

	@ManyToOne
	@JoinColumn(name = "pessoa_id_2")
	Cliente pessoaId2;

	@Column(nullable = false, length = 50, name = "parentesco")
	String parentesco;

	public Dependente() {}

	public Dependente(String parentesco, Cliente pessoaId1, Cliente pessoaId2) {
		this.parentesco = parentesco;
		this.pessoaId2 = pessoaId2;
		this.pessoaId1 = pessoaId1;
	}

	public String getParentesco() {
		return parentesco;
	}
}
