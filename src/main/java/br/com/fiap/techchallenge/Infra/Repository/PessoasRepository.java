package br.com.fiap.techchallenge.Infra.Repository;

import br.com.fiap.techchallenge.domain.Entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PessoasRepository extends JpaRepository<Cliente, String> {

	List<Cliente> findByNome(String nome);

	List<Cliente> findByGenero(String genero);

	//List<Cliente> findByParentesco(String parentesco);

}
