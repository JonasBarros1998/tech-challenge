package br.com.fiap.techchallenge.View.Controller.DTO;

import java.time.LocalDate;

public record DependenteDTO(
	String nome,
	String grauDeRelacionamento,
	String genero,
	LocalDate nascimento,
	String cpf
) {

}
