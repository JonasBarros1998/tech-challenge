package br.com.fiap.techchallenge.View.Controller.DTO;

import br.com.fiap.techchallenge.Dominio.Entidades.Cliente;
import br.com.fiap.techchallenge.Dominio.Entidades.Usuario;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class PessoaDTO {

	@Size(min = 11, max=11, message = "O cpf deve ter 11 digitos. Envie apenas os numeros sem formatação")
	private String cpf;

	@NotEmpty
	private String nome;

	@Past
	@NotNull
	private LocalDate nascimento;


	@NotEmpty
	private String genero;

	@NotNull
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private UUID usuarioID;

	private LocalDate dataDeCadastro;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String parentesco;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<DependenteDTO> relacionamento;

	public PessoaDTO(Cliente cliente) {
		this.cpf = cliente.getCpf();
		this.nome = cliente.getNome();
		this.nascimento = cliente.getNascimento();
		this.genero = cliente.getGenero();
	}
	
	public PessoaDTO(Cliente cliente, List<DependenteDTO> relacionamento) {
		this.cpf = cliente.getCpf();
		this.nome = cliente.getNome();
		this.nascimento = cliente.getNascimento();
		this.genero = cliente.getGenero();
		this.relacionamento = relacionamento;
	}

	public PessoaDTO(Cliente cliente, String parentesco) {
		this.cpf = cliente.getCpf();
		this.nome = cliente.getNome();
		this.nascimento = cliente.getNascimento();
		this.genero = cliente.getGenero();
		this.parentesco = parentesco;
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
		var cliente =  new Cliente(
			dependenteDTO.nome(),
			dependenteDTO.nascimento(),
			dependenteDTO.genero(),
			dependenteDTO.cpf()
		);

		cliente.setUsuario(new Usuario(dependenteDTO.usuarioID()));
		return cliente;
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

	public List<DependenteDTO> getRelacionamento() {
		return relacionamento;
	}

	public String getParentesco() {
		return parentesco;
	}

	public UUID getUsuarioID() {
		return usuarioID;
	}
}
