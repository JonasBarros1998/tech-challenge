package br.com.fiap.techchallenge.View.Controller.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record EditarDadosDaPessoaDTO(
	@NotEmpty
	String nome,

	@NotNull
	LocalDate nascimento,

	@NotEmpty
	String genero
) { }
