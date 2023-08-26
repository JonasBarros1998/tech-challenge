package br.com.fiap.techchallenge.domain.Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "dependentes")
public class Dependente extends Pessoa {

	@Column(nullable = false, length = 20)
	String tipo_dependencia;

	public Dependente(String name, LocalDate nascimento, String genero, String cpf) {
		super(name, nascimento, genero, cpf);
	}

	public Dependente() {}
}
