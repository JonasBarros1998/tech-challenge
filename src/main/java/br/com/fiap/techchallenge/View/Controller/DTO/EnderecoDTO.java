package br.com.fiap.techchallenge.View.Controller.DTO;

import br.com.fiap.techchallenge.domain.Entidades.Endereco;

import java.util.List;
import java.util.stream.Collectors;
import java.util.UUID;

public record EnderecoDTO (
	UUID id,
	String cep,
	String estado,
	String rua,
	String numero,
	String bairro,
	String cidade
) {

	public EnderecoDTO(Endereco endereco) {
		this(
			endereco.getId(),
			endereco.getRua(),
			endereco.getNumero(),
			endereco.getBairro(),
			endereco.getCidade(),
			endereco.getEstado(),
			endereco.getCep()
		);
	}

	public static List<EnderecoDTO> converterDeEnderecoParaEnderecoDTO(List<Endereco> enderecos) {
		return enderecos.stream()
			.map(EnderecoDTO::new)
			.collect(Collectors.toList());
	}

	public static EnderecoDTO converterDeEnderecoParaEnderecoDTO(Endereco endereco) {
		return new EnderecoDTO(endereco);
	}

	public static Endereco converterDeEnderecoParaEnderecoForm(EnderecoDTO enderecoForm) {
		return new Endereco(
			enderecoForm.rua(),
			enderecoForm.numero(),
			enderecoForm.bairro(),
			enderecoForm.cidade(),
			enderecoForm.estado(),
			enderecoForm.cep()
		);
	}

	public static Endereco atualizarEndereco(Endereco endereco, EnderecoDTO enderecoForm) {
		endereco.setCep(enderecoForm.cep());
		endereco.setRua(enderecoForm.rua());
		endereco.setBairro(enderecoForm.bairro());
		endereco.setCidade(enderecoForm.cidade());
		endereco.setEstado(enderecoForm.estado());
		endereco.setNumero(enderecoForm.numero());
		return endereco;
	}


}
