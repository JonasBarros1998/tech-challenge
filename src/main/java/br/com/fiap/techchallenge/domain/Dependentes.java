package br.com.fiap.techchallenge.domain;

import java.time.LocalDate;
import java.util.ArrayList;

public class Dependentes extends Pessoa  {

	public Dependentes(String name, LocalDate nascimento, String genero, String cpf) {
		super(name, nascimento, genero, cpf);
	}
}
