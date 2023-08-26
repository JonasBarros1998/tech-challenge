package br.com.fiap.techchallenge.Infra.Repository;

import br.com.fiap.techchallenge.domain.Entidades.Eletrodomestico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.List;

public interface EletrodomesticoRepository extends JpaRepository<Eletrodomestico, UUID> {

	List<Eletrodomestico> findByNome(String nome);

	List<Eletrodomestico> findByPotencia(BigDecimal potencia);

	List<Eletrodomestico> findByModelo(String modelo);

}
