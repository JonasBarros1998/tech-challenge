package br.com.fiap.techchallenge.View.Controller.DTO;

import br.com.fiap.techchallenge.domain.Entidades.Cliente;
import br.com.fiap.techchallenge.domain.Entidades.Pessoa;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.List;

public record PessoaDTO(
	@NotEmpty
	@CPF
	String cpf,

	@NotEmpty
	String nome,

	@Past
	@NotNull
	LocalDate nascimento,

	@NotEmpty
	String genero
) {

	public PessoaDTO(Pessoa pessoa) {
		this(
			pessoa.getCpf(),
			pessoa.getNome(),
			pessoa.getNascimento(),
			pessoa.getGenero()
		);
	}

	public static List<PessoaDTO> converterDeClienteParaPessoaDTO(List<Cliente> clientes) {
		return clientes.stream().map(PessoaDTO::new).toList();
	}

	public static PessoaDTO converterDeClienteParaPessoaDTO(Cliente cliente) {
		return new PessoaDTO(
			cliente.getCpf(),
			cliente.getNome(),
			cliente.getNascimento(),
			cliente.getGenero()
		);
	}

	public static Cliente converterDePessoaDTOParaCliente(PessoaDTO pessoaDTO) {
		return new Cliente(
			pessoaDTO.nome(),
			pessoaDTO.nascimento(),
			pessoaDTO.genero(),
			pessoaDTO.cpf()
		);
	}

}
