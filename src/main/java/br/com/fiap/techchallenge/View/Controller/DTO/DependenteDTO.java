package br.com.fiap.techchallenge.View.Controller.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;

public record DependenteDTO(

	@JsonInclude(JsonInclude.Include.NON_NULL)
	String nome,

	@JsonInclude(JsonInclude.Include.NON_NULL)
	String parentesco,

	@JsonInclude(JsonInclude.Include.NON_NULL)
	String genero,

	@JsonInclude(JsonInclude.Include.NON_NULL)
	LocalDate nascimento,

	@JsonInclude(JsonInclude.Include.NON_NULL)
	String cpf
) {

}
