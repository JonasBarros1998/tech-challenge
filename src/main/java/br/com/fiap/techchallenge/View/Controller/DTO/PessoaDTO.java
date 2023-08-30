package br.com.fiap.techchallenge.View.Controller.DTO;

import br.com.fiap.techchallenge.domain.Entidades.Cliente;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.List;

public class PessoaDTO {
	@NotEmpty
	@CPF
	private String cpf;

	@NotEmpty
	private String nome;

	@Past
	@NotNull
	private LocalDate nascimento;

	@NotEmpty
	private String genero;

	private List<DependenteDTO> dependentes;

	public PessoaDTO(Cliente cliente) {
		this.cpf = cliente.getCpf();
		this.nome = cliente.getNome();
		this.nascimento = cliente.getNascimento();
		this.genero = cliente.getGenero();
	}
	
	public PessoaDTO(Cliente cliente, List<DependenteDTO> dependentes) {
		this.cpf = cliente.getCpf();
		this.nome = cliente.getNome();
		this.nascimento = cliente.getNascimento();
		this.genero = cliente.getGenero();
		this.dependentes = dependentes;
	}

	public PessoaDTO() {}

	public static List<PessoaDTO> converterDeClienteParaPessoaDTO(List<Cliente> clientes) {
		return clientes.stream().map(PessoaDTO::new).toList();
	}


	public static PessoaDTO converterDeClienteParaPessoaDTO(Cliente cliente) {
		return new PessoaDTO(cliente);
	}

	public static Cliente converterDePessoaDTOParaCliente(PessoaDTO pessoaDTO) {
		return new Cliente(
			pessoaDTO.nome,
			pessoaDTO.nascimento,
			pessoaDTO.genero,
			pessoaDTO.cpf
		);
	}

	public static Cliente converterDeDependenteDTOParaCliente(DependenteDTO dependenteDTO) {
		return new Cliente(
			dependenteDTO.nome(),
			dependenteDTO.nascimento(),
			dependenteDTO.genero(),
			dependenteDTO.cpf()
		);
	}

	public String getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public LocalDate getNascimento() {
		return nascimento;
	}

	public String getGenero() {
		return genero;
	}

	public List<DependenteDTO> getDependentes() {
		return dependentes;
	}
}
