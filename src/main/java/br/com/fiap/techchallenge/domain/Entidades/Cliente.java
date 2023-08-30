package br.com.fiap.techchallenge.domain.Entidades;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
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

	@OneToMany(mappedBy = "pessoaId1", cascade = CascadeType.ALL)
	List<Dependente> dependentes = new ArrayList<>();

	public Cliente() {}

	public Cliente(String name, LocalDate nascimento, String genero, String cpf) {
		super(name, nascimento, genero, cpf);
	}

	public Cliente(String name, LocalDate nascimento, String genero, String cpf, List<Dependente> dependentes) {
		super(name, nascimento, genero, cpf);
		this.dependentes = dependentes;
	}

	public List<Endereco> getEnderecos() {
		return this.enderecos;
	}

	public LocalDate getDataDeCadastro() {
		return this.dataDeCadastro;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public List<Dependente> getDependentes() {
		return this.dependentes;
		
	}
}
