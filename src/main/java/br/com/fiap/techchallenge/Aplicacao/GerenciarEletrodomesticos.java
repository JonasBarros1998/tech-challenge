package br.com.fiap.techchallenge.Aplicacao;

import br.com.fiap.techchallenge.Dominio.Entidades.Usuario;
import br.com.fiap.techchallenge.Infra.Repository.EletrodomesticoRepository;
import br.com.fiap.techchallenge.View.Controller.DTO.EletrodomesticoDTO;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.math.BigDecimal;

@Service
public class GerenciarEletrodomesticos {

	EletrodomesticoRepository eletrodomesticoRepository;

	@Autowired
	public GerenciarEletrodomesticos(
		EletrodomesticoRepository eletrodomesticoRepository) {
		this.eletrodomesticoRepository = eletrodomesticoRepository;
	}

	public EletrodomesticoDTO salvar(EletrodomesticoDTO eletrodomesticoDTO) {
		var eletrodomestico = EletrodomesticoDTO.converterDeEletrodomesticoDTOParaEletrodomestico(eletrodomesticoDTO);
		this.eletrodomesticoRepository.save(eletrodomestico);
		return eletrodomesticoDTO;
	}

	public List<EletrodomesticoDTO> pesquisarPorNome(String nome) {
		var eletrodomesticos = this.eletrodomesticoRepository.findByNome(nome);
		return EletrodomesticoDTO.converterDeEletrodomesticoParaEletrodomesticoDTO(eletrodomesticos);
	}

	public List<EletrodomesticoDTO> pesquisarPorModelo(String nome) {
		var eletrodomesticos = this.eletrodomesticoRepository.findByModelo(nome);
		return EletrodomesticoDTO.converterDeEletrodomesticoParaEletrodomesticoDTO(eletrodomesticos);
	}

	public List<EletrodomesticoDTO> pesquisarPorPotencia(BigDecimal potenciaApartirDe, BigDecimal potenciaDeAte) {
		var eletrodomesticos = this.eletrodomesticoRepository.findByPotencia(potenciaApartirDe, potenciaDeAte);
		return EletrodomesticoDTO.converterDeEletrodomesticoParaEletrodomesticoDTO(eletrodomesticos);
	}

	public void remover(UUID enderecoId) {
		this.eletrodomesticoRepository.deleteById(enderecoId);
	}

}
