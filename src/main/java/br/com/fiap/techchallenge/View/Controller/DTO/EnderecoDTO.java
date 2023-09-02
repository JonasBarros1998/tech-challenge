package br.com.fiap.techchallenge.View.Controller.DTO;

import br.com.fiap.techchallenge.Dominio.Entidades.Cliente;
import br.com.fiap.techchallenge.Dominio.Entidades.Endereco;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.stream.Collectors;
import java.util.UUID;

public class EnderecoDTO {
	private UUID id;
	private String cep;
	private String estado;
	private String rua;
	private String numero;
	private String bairro;
	private String cidade;
	@JsonInclude(value = JsonInclude.Include.NON_NULL)
	private Cliente cliente;

	public EnderecoDTO(UUID id, String cep, String estado, String rua, String numero, String bairro, String cidade) {
		this.id = id;
		this.cep = cep;
		this.estado = estado;
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
	}

	public EnderecoDTO(Endereco endereco) {
		this.id = endereco.getId();
		this.rua = endereco.getRua();
		this.numero = endereco.getNumero();
		this.bairro = endereco.getBairro();
		this.cidade = endereco.getCidade();
		this.estado = endereco.getEstado();
		this.cep = endereco.getCep();
		this.cliente = endereco.getCliente();
	}

	public UUID getId() {
		return id;
	}

	public String getCep() {
		return cep;
	}

	public String getEstado() {
		return estado;
	}

	public String getRua() {
		return rua;
	}

	public String getNumero() {
		return numero;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public static List<EnderecoDTO> converterDeEnderecoParaEnderecoDTO(List<Endereco> enderecos) {
		return enderecos.stream()
			.map(EnderecoDTO::new)
			.collect(Collectors.toList());
	}

	public static EnderecoDTO converterDeEnderecoParaEnderecoDTO(Endereco endereco) {
		return new EnderecoDTO(endereco);
	}

	public static Endereco converterDeEnderecoParaEnderecoDTO(EnderecoDTO enderecoForm) {
		return new Endereco(
			enderecoForm.getRua(),
			enderecoForm.getNumero(),
			enderecoForm.getBairro(),
			enderecoForm.getCidade(),
			enderecoForm.getEstado(),
			enderecoForm.getCep(),
			enderecoForm.getCliente()
		);
	}

	public static Endereco atualizarEndereco(Endereco endereco, EnderecoDTO enderecoForm) {
		endereco.setCep(enderecoForm.getCep());
		endereco.setRua(enderecoForm.getRua());
		endereco.setBairro(enderecoForm.getBairro());
		endereco.setCidade(enderecoForm.getCidade());
		endereco.setEstado(enderecoForm.getEstado());
		endereco.setNumero(enderecoForm.getNumero());
		return endereco;
	}

	public static EnderecoDTO formatarRespostaDeEnderecoParaEditarEnderecoSaida(Endereco endereco) {
		return new EnderecoDTO(
			endereco.getId(),
			endereco.getCep(),
			endereco.getEstado(),
			endereco.getRua(),
			endereco.getNumero(),
			endereco.getBairro(),
			endereco.getCidade()
		);
	}
}
