package br.com.fiap.techchallenge.Infra.Repository;

import br.com.fiap.techchallenge.domain.Entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;


public interface PessoaRepository extends JpaRepository<Cliente, String> {

	@Query(value = "select dependentes.nome, " +
		"dependentes.cpf, dependentes.genero, " +
		"dependentes.nascimento, " +
		"dependentes.data_de_cadastro, " +
		"relacionamento.parentesco from pessoas pessoa " +
		"join relacionamento relacionamento on pessoa.cpf = relacionamento.pessoa_id_1 " +
		"join pessoas dependentes on dependentes.cpf = relacionamento.pessoa_id_2 " +
		"where pessoa.cpf = :cpf", nativeQuery = true)
	List<Cliente> pesquisarPorDependentes(String cpf);

	List<Cliente> findByGenero(String genero);

	List<Cliente> findByNome(String nome);

	@Query(value = "select dependentes.nome, dependentes.cpf, dependentes.genero, dependentes.nascimento, dependentes.data_de_cadastro, relacionamento.parentesco from pessoas pessoa " +
		"join relacionamento relacionamento on pessoa.cpf = relacionamento.pessoa_id_1 " +
		"join pessoas dependentes on dependentes.cpf = relacionamento.pessoa_id_2 " +
		"where pessoa.cpf = :cpf and relacionamento.parentesco = :parentesco", nativeQuery = true)
	List<Cliente> pesquisarPorParentesco(String cpf, String parentesco);

}