package br.com.fiap.techchallenge.Infra.Repository;
import br.com.fiap.techchallenge.domain.Entidades.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface EnderecoRepository extends JpaRepository<Endereco, UUID> {

}
