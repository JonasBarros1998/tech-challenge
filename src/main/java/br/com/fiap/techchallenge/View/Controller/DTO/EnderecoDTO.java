package br.com.fiap.techchallenge.View.Controller.DTO;

import br.com.fiap.techchallenge.View.Controller.EnderecoForm;
import br.com.fiap.techchallenge.domain.Entidades.Endereco;

import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.util.UUID;

public class EnderecoDTO {

	private UUID id;

	private String cep;

	private String estado;

	private String rua;

	private String numero;

	private String bairro;

	private String cidade;

	public EnderecoDTO(Endereco endereco) {
		this.id = endereco.getId();
		this.rua = endereco.getRua();
		this.numero = endereco.getNumero();
		this.bairro = endereco.getBairro();
		this.cidade = endereco.getCidade();
		this.estado = endereco.getEstado();
		this.cep = endereco.getCep();
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

	public static List<EnderecoDTO> converterPara(Spliterator<Endereco> enderecos) {
		return StreamSupport.stream(enderecos, false)
			.map(EnderecoDTO::new)
			.collect(Collectors.toList());
	}

	public static EnderecoDTO converterPara(Endereco endereco) {
		return new EnderecoDTO(endereco);
	}

	public static Endereco converterPara(EnderecoForm enderecoForm) {
		return new Endereco(
			enderecoForm.rua(),
			enderecoForm.numero(),
			enderecoForm.bairro(),
			enderecoForm.cidade(),
			enderecoForm.estado(),
			enderecoForm.cep()
		);
	}

	public static Endereco atualizarEndereco(Endereco endereco, EnderecoForm enderecoForm) {
		endereco.setCep(enderecoForm.cep());
		endereco.setRua(enderecoForm.rua());
		endereco.setBairro(enderecoForm.bairro());
		endereco.setCidade(enderecoForm.cidade());
		endereco.setEstado(enderecoForm.estado());
		endereco.setNumero(enderecoForm.numero());
		return endereco;
	}


}
