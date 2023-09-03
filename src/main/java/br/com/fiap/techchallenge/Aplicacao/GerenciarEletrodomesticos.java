package br.com.fiap.techchallenge.Aplicacao;

import br.com.fiap.techchallenge.Aplicacao.Exceptions.InformacaoNaoEncontrada;
import br.com.fiap.techchallenge.Dominio.Entidades.EficienciaEnergetica;
import br.com.fiap.techchallenge.Dominio.Entidades.Usuario;
import br.com.fiap.techchallenge.Infra.Repository.EletrodomesticoRepository;
import br.com.fiap.techchallenge.View.Controller.DTO.AdicionarUsuarioAoEletrodomesticoDTO;
import br.com.fiap.techchallenge.View.Controller.DTO.EletrodomesticoDTO;
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

	public EletrodomesticoDTO editarEletrodomestico(EletrodomesticoDTO eletrodomesticoDTO, UUID id) {

		var eletrodomestico = this.eletrodomesticoRepository.findById(id)
			.orElseThrow(() -> new InformacaoNaoEncontrada("Nao foi possivel buscar o ID do eletrodomestico"));

		eletrodomestico.setMarca(eletrodomesticoDTO.getMarca());
		eletrodomestico.setNome(eletrodomesticoDTO.getNome());
		eletrodomestico.setVolts(eletrodomesticoDTO.getVolts());
		eletrodomestico.setModelo(eletrodomesticoDTO.getModelo());

		eletrodomestico.setEficienciaEnergetica(
			new EficienciaEnergetica(
				eletrodomesticoDTO.getEficienciaEnergetica().consumoEnergetico(),
				eletrodomesticoDTO.getEficienciaEnergetica().classificacao(),
				eletrodomesticoDTO.getEficienciaEnergetica().porcentagemDeEconomia())
		);

		this.eletrodomesticoRepository.save(eletrodomestico);
		return EletrodomesticoDTO.converterDeEletrodomesticoParaEletrodomesticoDTO(eletrodomestico);
	}


	public EletrodomesticoDTO adicionarUsuarioAoEletrodomestico(AdicionarUsuarioAoEletrodomesticoDTO novoUsuario, UUID eletrodomesticoID) {
		var eletrodomestico = this.eletrodomesticoRepository.findById(eletrodomesticoID)
			.orElseThrow(() -> new InformacaoNaoEncontrada("Nao foi possivel buscar o ID do eletrodomestico"));

		eletrodomestico.addUsuario(new Usuario(novoUsuario.usuario()));
		eletrodomesticoRepository.save(eletrodomestico);
		return EletrodomesticoDTO.converterDeEletrodomesticoParaEletrodomesticoDTO(eletrodomestico);
	}

	public void removerEletrodomestico(UUID eletrodomesticoID) {
		this.eletrodomesticoRepository.deleteById(eletrodomesticoID);
	}

}
