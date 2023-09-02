package br.com.fiap.techchallenge.Infra.Repository;

import br.com.fiap.techchallenge.Dominio.Entidades.Eletrodomestico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.List;

public interface EletrodomesticoRepository extends JpaRepository<Eletrodomestico, UUID> {

	List<Eletrodomestico> findByNome(String nome);

	@Query(value = "select * from eletrodomesticos as eletrodomestico " +
		"where eletrodomestico.potencia between :potenciaApartirDe and :potenciaDeAte", nativeQuery = true)
	List<Eletrodomestico> findByPotencia(BigDecimal potenciaApartirDe, BigDecimal potenciaDeAte);

	List<Eletrodomestico> findByModelo(String modelo);

}
