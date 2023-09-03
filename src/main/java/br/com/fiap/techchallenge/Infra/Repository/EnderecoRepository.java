package br.com.fiap.techchallenge.Infra.Repository;
import br.com.fiap.techchallenge.Dominio.Entidades.Cliente;
import br.com.fiap.techchallenge.Dominio.Entidades.Endereco;
import br.com.fiap.techchallenge.Dominio.Entidades.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EnderecoRepository extends JpaRepository<Endereco, UUID> {

	List<Endereco> findByBairro(String bairro);

	List<Endereco> findByCidade(String cidade);

	List<Endereco> findByRua(String rua);

	List<Endereco> findByEstado(String estado);

	@Query("SELECT endereco FROM Endereco endereco")
	List<Endereco> findAll();

	@Query(value = "select endereco.id as id, endereco.bairro as bairro, " +
		"endereco.cep as cep, endereco.cidade as cidade, endereco.estado as estado, " +
		"endereco.numero as numero, endereco.rua as rua, " +
		"pessoa.cpf, pessoa.genero, pessoa.usuario_id, pessoa.nascimento, pessoa.nome as nome from enderecos as endereco " +
		"join usuarios as usuario on usuario.id = endereco.usuario_id " +
		"join pessoas as pessoa on pessoa.usuario_id = endereco.usuario_id " +
		"where endereco.id = :enderecoID", nativeQuery = true)
	Optional<List<Endereco>> pesquisarPorUsuariosPorIdDoEndereco(UUID enderecoID);

	@Query(value = "select endereco.id as id, endereco.bairro as bairro, " +
		"endereco.cep as cep, endereco.cidade as cidade, endereco.estado as estado, " +
		"endereco.numero as numero, endereco.rua as rua, endereco.usuario_id as usuario_id, usuario.email as email " +
		"from enderecos as endereco " +
		"join usuarios as usuario on usuario.id = endereco.usuario_id " +
		"join pessoas as pessoa on pessoa.usuario_id = endereco.usuario_id " +
		"where pessoa.cpf = :cpf", nativeQuery = true)
	List<Endereco> pesquisarEnderecoPorCpf(String cpf);
}
