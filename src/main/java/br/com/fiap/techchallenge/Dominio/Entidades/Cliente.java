package br.com.fiap.techchallenge.Dominio.Entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "pessoas")
public class Cliente extends Pessoa {

	@Column(insertable = true)
	private final LocalDate dataDeCadastro = LocalDate.now();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoaId2")
	List<Dependente> grauDeParentesco;

	@OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	@JsonBackReference
	Usuario usuario;

	public Cliente() {}

	public Cliente(String name, LocalDate nascimento, String genero, String cpf) {
		super(name, nascimento, genero, cpf);
	}

	public LocalDate getDataDeCadastro() {
		return this.dataDeCadastro;
	}

	public List<Dependente> getGrauDeParentesco() {
		return grauDeParentesco;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
