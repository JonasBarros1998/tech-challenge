package br.com.fiap.techchallenge.Aplicacao;

import br.com.fiap.techchallenge.Aplicacao.Utils.TipoDePesquisaParaEndereco;
import br.com.fiap.techchallenge.Infra.Repository.EnderecoRepository;
import br.com.fiap.techchallenge.View.Controller.DTO.EnderecoDTO;
import br.com.fiap.techchallenge.domain.Entidades.Endereco;
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
		Endereco endereco = EnderecoDTO.converterDeEnderecoParaEnderecoForm(enderecoDTO);
		this.enderecoRepository.save(endereco);
		return EnderecoDTO.converterDeEnderecoParaEnderecoDTO(endereco);
	}

	@Transactional
	public EnderecoDTO atualizar(UUID id, EnderecoDTO enderecoForm) {
		var endereco = this.enderecoRepository.findById(id).orElse(null);
		endereco = EnderecoDTO.atualizarEndereco(endereco, enderecoForm);
		this.enderecoRepository.save(endereco);
		return EnderecoDTO.converterDeEnderecoParaEnderecoDTO(endereco);
	}

	public List<EnderecoDTO> listar() {
		var enderecos = this.enderecoRepository.findAll();
		return EnderecoDTO.converterDeEnderecoParaEnderecoDTO(enderecos);
	}

	public List<EnderecoDTO> pesquisarPor(String nome, String tipo) {
		TipoDePesquisaParaEndereco tipoDePesquisa = TipoDePesquisaParaEndereco.valueOf(tipo.toUpperCase());

		switch (tipoDePesquisa) {
			case BAIRRO:
				this.enderecos = this.enderecoRepository.findByBairro(nome);
				break;
			case CIDADE:
				this.enderecos = this.enderecoRepository.findByCidade(nome);
				break;
			case ESTADO:
				this.enderecos = this.enderecoRepository.findByEstado(nome);
				break;
			case RUA:
				this.enderecos = this.enderecoRepository.findByRua(nome);
				break;
			default:
				System.out.println("Nenhuma pesquisa encontrada");
				break;
		}

		return EnderecoDTO.converterDeEnderecoParaEnderecoDTO(this.enderecos);
	}

	public List<EnderecoDTO> pesquisarPor(UUID id) {
		List<Endereco> endereco = new ArrayList();

		this.enderecoRepository.findById(id)
			.ifPresentOrElse(
				(enderecoDoCliente) -> {
					endereco.add(enderecoDoCliente);
				},
				() -> new ArrayList<EnderecoDTO>());

		return EnderecoDTO.converterDeEnderecoParaEnderecoDTO(endereco);

	}

	public void remover(UUID id) {
			this.enderecoRepository.deleteById(id);
	}

}
