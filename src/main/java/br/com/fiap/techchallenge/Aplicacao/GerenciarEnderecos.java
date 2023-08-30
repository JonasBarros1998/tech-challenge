package br.com.fiap.techchallenge.Aplicacao;

import br.com.fiap.techchallenge.Infra.Repository.EnderecoRepository;
import br.com.fiap.techchallenge.View.Controller.DTO.EnderecoDTO;
import br.com.fiap.techchallenge.View.Controller.Saida.ConsultarEndereco;
import br.com.fiap.techchallenge.domain.Entidades.Endereco;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class GerenciarEnderecos {

	EnderecoRepository enderecoRepository;

	List<Endereco> enderecos;

	@Autowired
	GerenciarEnderecos(EnderecoRepository enderecoRepository) {
		this.enderecoRepository = enderecoRepository;
	}

	public EnderecoDTO salvar(EnderecoDTO enderecoDTO) {
		var endereco = EnderecoDTO.converterDeEnderecoParaEnderecoDTO(enderecoDTO);
		this.enderecoRepository.save(endereco);
		return EnderecoDTO.converterDeEnderecoParaEnderecoDTO(endereco);
	}

	@Transactional
	public EnderecoDTO atualizar(UUID id, EnderecoDTO enderecoDTO) {
		var endereco = this.enderecoRepository.findById(id).orElse(null);
		endereco = EnderecoDTO.atualizarEndereco(endereco, enderecoDTO);
		this.enderecoRepository.save(endereco);
		return EnderecoDTO.formatarRespostaDeEnderecoParaEditarEnderecoSaida(endereco);
	}

	public List<EnderecoDTO> listar() {
		var enderecos = this.enderecoRepository.findAll();

		return EnderecoDTO.converterDeEnderecoParaEnderecoDTO(enderecos);
	}

	public List<EnderecoDTO> pesquisarPorBairro(String bairro) {
		this.enderecos = this.enderecoRepository.findByBairro(bairro);
		return EnderecoDTO.converterDeEnderecoParaEnderecoDTO(this.enderecos);
	}

	public List<EnderecoDTO> pesquisarPorCidade(String cidade) {
		this.enderecos = this.enderecoRepository.findByCidade(cidade);
		return EnderecoDTO.converterDeEnderecoParaEnderecoDTO(this.enderecos);
	}

	public List<EnderecoDTO> pesquisarPorRua(String rua) {
		this.enderecos = this.enderecoRepository.findByRua(rua);
		return EnderecoDTO.converterDeEnderecoParaEnderecoDTO(this.enderecos);
	}

	public List<EnderecoDTO> pesquisarPorEstado(String estado) {
		this.enderecos = this.enderecoRepository.findByEstado(estado);
		return EnderecoDTO.converterDeEnderecoParaEnderecoDTO(this.enderecos);
	}

	public List<EnderecoDTO> pesquisarPor(UUID id) {
		List<Endereco> endereco = new ArrayList();

		this.enderecoRepository.findById(id)
			.ifPresentOrElse(
				(enderecoDoCliente) -> endereco.add(enderecoDoCliente),
				() -> new ArrayList<EnderecoDTO>());

		return EnderecoDTO.converterDeEnderecoParaEnderecoDTO(endereco);

	}

	public void remover(UUID id) {
			this.enderecoRepository.deleteById(id);
	}

}
