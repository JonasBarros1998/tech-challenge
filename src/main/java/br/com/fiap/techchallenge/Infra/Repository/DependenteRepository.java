package br.com.fiap.techchallenge.Infra.Repository;

import br.com.fiap.techchallenge.domain.Entidades.Dependente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DependenteRepository extends JpaRepository<Dependente, String> {
}
