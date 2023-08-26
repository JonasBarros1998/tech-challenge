package br.com.fiap.techchallenge.domain.Entidades;

import br.com.fiap.techchallenge.domain.enums.EficienciaEnergeticaClassificacao;
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
	@Column(length = 1)
	EficienciaEnergeticaClassificacao classificacao;

	@Column(nullable = false)
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
