package br.com.fiap.techchallenge.Infra.Repository;
import br.com.fiap.techchallenge.domain.Entidades.Endereco;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;

public interface EnderecoRepository extends JpaRepository<Endereco, UUID> {

	List<Endereco> findByBairro(String bairro);

	List<Endereco> findByCidade(String cidade);

	List<Endereco> findByRua(String rua);

	List<Endereco> findByEstado(String estado);
}
