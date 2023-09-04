package br.com.fiap.techchallenge.Aplicacao;

import br.com.fiap.techchallenge.Aplicacao.Exceptions.InformacaoNaoEncontrada;
import br.com.fiap.techchallenge.Dominio.Entidades.Usuario;
import br.com.fiap.techchallenge.Infra.Repository.DependenteRepository;
import br.com.fiap.techchallenge.Infra.Repository.PessoaRepository;
import br.com.fiap.techchallenge.View.Controller.DTO.EditarDadosDaPessoaDTO;
import br.com.fiap.techchallenge.View.Controller.DTO.PessoaDTO;
import br.com.fiap.techchallenge.Dominio.Entidades.Cliente;
import br.com.fiap.techchallenge.Dominio.Entidades.Dependente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
		pessoa.setUsuario(new Usuario(pessoaDTO.getUsuarioID()));
		pessoas.add(pessoa);

		if(pessoaDTO.getRelacionamento() != null) {
			pessoaDTO.getRelacionamento().stream()
				.forEach((item) -> {
					var dependente = PessoaDTO.converterDeDependenteDTOParaCliente(item);
					pessoas.add(dependente);
					dependentes.add(new Dependente(item.parentesco(), pessoa, dependente));
				});
		}

		this.pessoaRepository.saveAll(pessoas);
		this.dependenteRepository.saveAll(dependentes);
		return pessoaDTO;
	}

	public List<PessoaDTO> listar() {
		List<Cliente> clientes = this.pessoaRepository.findAll();
		return PessoaDTO.converterDeClienteParaPessoaDTO(clientes);
	}


	@Transactional
	public PessoaDTO editarPessoa(EditarDadosDaPessoaDTO pessoaDTO, String pessoaCPF) {
		Cliente cliente = this.pessoaRepository.findById(pessoaCPF)
			.orElseThrow(() -> new InformacaoNaoEncontrada("Nao foi possivel encontrar o ID da pessoa"));

		cliente.setCpf(pessoaCPF);
		cliente.setNascimento(pessoaDTO.nascimento());
		cliente.setNome(pessoaDTO.nome());
		cliente.setGenero(pessoaDTO.genero());
		this.pessoaRepository.save(cliente);

		return PessoaDTO.converterDeClienteParaPessoaDTO(cliente);
	}

	public void remover(String cpf) {
		this.pessoaRepository.deleteById(cpf);
	}

	public List<PessoaDTO> pesquisarPorGenero(String genero) {
		List<Cliente> clientes = this.pessoaRepository.findByGenero(genero);
		return PessoaDTO.converterDeClienteParaPessoaDTO(clientes);
	}

	public List<Cliente> pesquisarPorDependentes(String genero) {
		var clientes = this.pessoaRepository.pesquisarPorDependentes(genero);
		return clientes;
	}

	public List<PessoaDTO> pesquisarPorNome(String genero) {
		List<Cliente> clientes = this.pessoaRepository.findByNome(genero);
		return PessoaDTO.converterDeClienteParaPessoaDTO(clientes);
	}

	public List<Cliente> pesquisarPorParentesco(String cpf, String tipo) {
		List<Cliente> clientes = this.pessoaRepository.pesquisarPorParentesco(cpf, tipo);
		return clientes;
	}
}
