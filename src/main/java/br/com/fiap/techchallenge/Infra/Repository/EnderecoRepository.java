package br.com.fiap.techchallenge.Infra.Repository;
import br.com.fiap.techchallenge.Dominio.Entidades.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface EnderecoRepository extends JpaRepository<Endereco, UUID> {

	List<Endereco> findByBairro(String bairro);

	List<Endereco> findByCidade(String cidade);

	List<Endereco> findByRua(String rua);

	List<Endereco> findByEstado(String estado);

	@Query("SELECT endereco FROM Endereco endereco")
	List<Endereco> findAll();
}
