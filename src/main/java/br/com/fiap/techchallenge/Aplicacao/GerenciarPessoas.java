package br.com.fiap.techchallenge.Aplicacao;

import br.com.fiap.techchallenge.Infra.Repository.DependenteRepository;
import br.com.fiap.techchallenge.Infra.Repository.PessoaRepository;
import br.com.fiap.techchallenge.View.Controller.DTO.PessoaDTO;
import br.com.fiap.techchallenge.domain.Entidades.Cliente;
import br.com.fiap.techchallenge.domain.Entidades.Dependente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GerenciarPessoas {

	PessoaRepository pessoaRepository;
	DependenteRepository dependenteRepository;

	@Autowired
	GerenciarPessoas(PessoaRepository pessoaRepository, DependenteRepository dependenteRepository) {
		this.pessoaRepository = pessoaRepository;
		this.dependenteRepository = dependenteRepository;
	}

	public PessoaDTO salvar(PessoaDTO pessoaDTO) {

		List<Cliente> pessoas = new ArrayList<>();
		List<Dependente> dependentes = new ArrayList<>();

		var pessoa = PessoaDTO.converterDePessoaDTOParaCliente(pessoaDTO);
		pessoas.add(pessoa);

		pessoaDTO.getDependentes().stream()
			.forEach((item) -> {
				var dependente = PessoaDTO.converterDeDependenteDTOParaCliente(item);
				pessoas.add(dependente);
				dependentes.add(new Dependente(item.grauDeRelacionamento(), pessoa, dependente));
			});

		this.pessoaRepository.saveAll(pessoas);
		this.dependenteRepository.saveAll(dependentes);
		return pessoaDTO;
	}

	public List<PessoaDTO> listar() {
		List<Cliente> clientes = this.pessoaRepository.findAll();
		return PessoaDTO.converterDeClienteParaPessoaDTO(clientes);
	}

	public PessoaDTO editar(PessoaDTO pessoaDTO, String idPessoa) {
		Cliente cliente = this.pessoaRepository.findById(idPessoa).orElse(null);

		cliente.setCpf(pessoaDTO.getCpf());
		cliente.setNascimento(pessoaDTO.getNascimento());
		cliente.setNome(pessoaDTO.getNome());
		cliente.setGenero(pessoaDTO.getGenero());

		this.pessoaRepository.save(cliente);

		return PessoaDTO.converterDeClienteParaPessoaDTO(cliente);
	}

	public void remover(String idPessoa) {
		this.pessoaRepository.deleteById(idPessoa);
	}

	public List<PessoaDTO> pesquisarPorNome(String nome) {
		List<Cliente> clientes = this.pessoaRepository.findByNome(nome);
		return PessoaDTO.converterDeClienteParaPessoaDTO(clientes);
	}

	public List<PessoaDTO> pesquisarPorGenero(String genero) {
		List<Cliente> clientes = this.pessoaRepository.findByGenero(genero);
		return PessoaDTO.converterDeClienteParaPessoaDTO(clientes);
	}

}
