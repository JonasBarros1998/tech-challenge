package br.com.fiap.techchallenge.Aplicacao.Endereco;

import br.com.fiap.techchallenge.Infra.Repository.EnderecoRepository;
import br.com.fiap.techchallenge.View.Controller.DTO.EnderecoDTO;
import br.com.fiap.techchallenge.View.Controller.EnderecoForm;
import br.com.fiap.techchallenge.domain.Entidades.Endereco;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class GerenciarEnderecos {

	EnderecoRepository enderecoRepository;

	EntityManager entityManager;

	@Autowired
	GerenciarEnderecos(EnderecoRepository enderecoRepository, EntityManager entityManger) {
		this.enderecoRepository = enderecoRepository;
		this.entityManager = entityManger;
	}

	public EnderecoDTO salvar(EnderecoForm enderecoForm) {
		Endereco endereco = EnderecoDTO.converterPara(enderecoForm);
		this.enderecoRepository.save(endereco);
		return EnderecoDTO.converterPara(endereco);
	}

	public List<EnderecoDTO> listar() {
		var enderecos = this.enderecoRepository.findAll();
		return EnderecoDTO.converterPara(enderecos.spliterator());
	}

	@Transactional
	public EnderecoDTO atualizar(UUID id, EnderecoForm enderecoForm) {
		var endereco = this.enderecoRepository.findById(id).orElse(null);
		endereco = EnderecoDTO.atualizarEndereco(endereco, enderecoForm);
		this.enderecoRepository.save(endereco);
		return EnderecoDTO.converterPara(endereco);
	}

}
