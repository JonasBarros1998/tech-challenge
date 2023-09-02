package br.com.fiap.techchallenge.Infra.Repository;

import br.com.fiap.techchallenge.Dominio.Entidades.Dependente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface DependenteRepository extends JpaRepository<Dependente, UUID> {
	@Query(value = "select * " +
		"from relacionamento as dependente " +
		"join pessoas as pessoa_id_2 on pessoa_id_2.cpf = dependente.pessoa_id_2 " +
		"where dependente.id = :id", nativeQuery = true)
	Dependente pesquisarDependente(UUID id);

}
