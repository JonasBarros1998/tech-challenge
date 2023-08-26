package br.com.fiap.techchallenge.Aplicacao;

import br.com.fiap.techchallenge.Infra.Repository.PessoasRepository;
import br.com.fiap.techchallenge.View.Controller.DTO.PessoaDTO;
import br.com.fiap.techchallenge.domain.Entidades.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GerenciarPessoas {

	PessoasRepository pessoaRepository;

	@Autowired
	GerenciarPessoas(PessoasRepository pessoaRepository) {
		this.pessoaRepository = pessoaRepository;
	}

	public PessoaDTO salvar(PessoaDTO pessoaDTO) {
		var cliente = pessoaDTO.converterDePessoaDTOParaCliente(pessoaDTO);
		this.pessoaRepository.save(cliente);
		return pessoaDTO;
	}

	public List<PessoaDTO> listar() {
		List<Cliente> clientes = this.pessoaRepository.findAll();
		return PessoaDTO.converterDeClienteParaPessoaDTO(clientes);
	}

	public PessoaDTO editar(PessoaDTO pessoaDTO, String idPessoa) {
		Cliente cliente = this.pessoaRepository.findById(idPessoa).orElse(null);

		cliente.setCpf(pessoaDTO.cpf());
		cliente.setNascimento(pessoaDTO.nascimento());
		cliente.setNome(pessoaDTO.nome());
		cliente.setGenero(pessoaDTO.genero());

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
