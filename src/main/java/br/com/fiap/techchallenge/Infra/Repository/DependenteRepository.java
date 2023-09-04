package br.com.fiap.techchallenge.Infra.Repository;

import br.com.fiap.techchallenge.Dominio.Entidades.Dependente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface DependenteRepository extends JpaRepository<Dependente, UUID> {
}
