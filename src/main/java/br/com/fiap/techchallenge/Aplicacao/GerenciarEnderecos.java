package br.com.fiap.techchallenge.Aplicacao;

import br.com.fiap.techchallenge.Aplicacao.Exceptions.InformacaoNaoEncontrada;
import br.com.fiap.techchallenge.Dominio.Entidades.Cliente;
import br.com.fiap.techchallenge.Dominio.Entidades.Pessoa;
import br.com.fiap.techchallenge.Infra.Repository.EnderecoRepository;
import br.com.fiap.techchallenge.View.Controller.DTO.EnderecoDTO;
import br.com.fiap.techchallenge.Dominio.Entidades.Endereco;
import br.com.fiap.techchallenge.View.Controller.DTO.PessoaDTO;
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
		var endereco = EnderecoDTO.converterDeEnderecoDTOParaEndereco(enderecoDTO);
		this.enderecoRepository.save(endereco);
		return EnderecoDTO.converterDeEnderecoParaEnderecoDTO(endereco);
	}

	@Transactional
	public EnderecoDTO atualizar(UUID id, EnderecoDTO enderecoDTO) {
		var endereco = this.enderecoRepository.findById(id)
			.orElseThrow(() -> new InformacaoNaoEncontrada("ID do endereco nao encontrado"));
		endereco = EnderecoDTO.atualizarEndereco(endereco, enderecoDTO);
		this.enderecoRepository.save(endereco);
		return EnderecoDTO.formatarRespostaDeEnderecoParaEditarEnderecoSaida(endereco);
	}

	public List<EnderecoDTO> listar() {
		var enderecos = this.enderecoRepository.findAll();
		return EnderecoDTO.converterDeEnderecoDTOParaEndereco(enderecos);
	}

	public List<EnderecoDTO> pesquisarPorBairro(String bairro) {
		this.enderecos = this.enderecoRepository.findByBairro(bairro);
		return EnderecoDTO.converterDeEnderecoDTOParaEndereco(this.enderecos);
	}

	public List<EnderecoDTO> pesquisarPorCidade(String cidade) {
		this.enderecos = this.enderecoRepository.findByCidade(cidade);
		return EnderecoDTO.converterDeEnderecoDTOParaEndereco(this.enderecos);
	}

	public List<EnderecoDTO> pesquisarPorRua(String rua) {
		this.enderecos = this.enderecoRepository.findByRua(rua);
		return EnderecoDTO.converterDeEnderecoDTOParaEndereco(this.enderecos);
	}

	public List<EnderecoDTO> pesquisarPorEstado(String estado) {
		this.enderecos = this.enderecoRepository.findByEstado(estado);
		return EnderecoDTO.converterDeEnderecoDTOParaEndereco(this.enderecos);
	}

	public List<EnderecoDTO> pesquisarPor(UUID id) {
		List<Endereco> endereco = new ArrayList();

		this.enderecoRepository.findById(id)
			.ifPresentOrElse(
				(enderecoDoCliente) -> endereco.add(enderecoDoCliente),
				() -> new ArrayList<EnderecoDTO>());

		return EnderecoDTO.converterDeEnderecoDTOParaEndereco(endereco);
	}

	public List<EnderecoDTO> pesquisarEnderecoPorCpf(String cpf) {
		var enderecos = this.enderecoRepository.pesquisarEnderecoPorCpf(cpf);
		return EnderecoDTO.converterDeEnderecoParaEnderecoDTO(enderecos);
	}

	public List<PessoaDTO> pesquisarEnderecoPorPessoa(UUID endereco) {
		var enderecos = this.enderecoRepository.pesquisarPorUsuariosPorIdDoEndereco(endereco)
			.orElseThrow(() -> new InformacaoNaoEncontrada("ID do endereco nao encontrado"));
		var clientes = enderecos.stream().map((clienteItem) -> {
			var cliente = clienteItem.getUsuario().getCliente();
			return new Cliente(cliente.getNome(), cliente.getDataDeCadastro(), cliente.getGenero(), cliente.getCpf());
		}).toList();
		return PessoaDTO.converterDeClienteParaPessoaDTO(clientes);
	}

	public void remover(UUID id) {
			this.enderecoRepository.deleteById(id);
	}



}
