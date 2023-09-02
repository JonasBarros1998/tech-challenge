package br.com.fiap.techchallenge.Dominio.Entidades;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "pessoas")
public class Cliente extends Pessoa {

	@Column(insertable = true)
	private final LocalDate dataDeCadastro = LocalDate.now();

	@JsonInclude(value = JsonInclude.Include.NON_NULL)
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	@Column(nullable = false)
	List<Endereco> enderecos;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoaId2")
	List<Dependente> grauDeParentesco;

	public Cliente() {}

	public Cliente(String name, LocalDate nascimento, String genero, String cpf) {
		super(name, nascimento, genero, cpf);
	}

	public LocalDate getDataDeCadastro() {
		return this.dataDeCadastro;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public List<Dependente> getGrauDeParentesco() {
		return grauDeParentesco;
	}

}
