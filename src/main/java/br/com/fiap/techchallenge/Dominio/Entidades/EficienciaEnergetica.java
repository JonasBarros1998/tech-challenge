package br.com.fiap.techchallenge.Dominio.Entidades;

import br.com.fiap.techchallenge.Dominio.enums.EficienciaEnergeticaClassificacao;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.math.BigDecimal;

@Embeddable
public class EficienciaEnergetica {

	@Column(nullable = false)
	BigDecimal consumoEnergetico;

	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "varchar(1)")
	EficienciaEnergeticaClassificacao classificacao;

	@Column()
	BigDecimal porcentagemDeEconomia;

	public EficienciaEnergetica() {}

	public EficienciaEnergetica(
		BigDecimal consumo,
		EficienciaEnergeticaClassificacao eficienciaEnergetica,
		BigDecimal porcentagemDeEconomia) {
		this.consumoEnergetico = consumo;
		this.classificacao = eficienciaEnergetica;
		this.porcentagemDeEconomia = porcentagemDeEconomia;
	}

	public EficienciaEnergeticaClassificacao getClassificacao() {
		return this.classificacao;
	}

	public BigDecimal getConsumoEnergetico() {
		return this.consumoEnergetico;
	}

	public BigDecimal getPorcentagemDeEconomia() {
		return porcentagemDeEconomia;
	}
}
