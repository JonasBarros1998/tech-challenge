package br.com.fiap.techchallenge.Dominio;

import br.com.fiap.techchallenge.Dominio.Entidades.Eletrodomestico;
import org.springframework.cglib.core.Local;

import java.math.BigDecimal;
import java.time.LocalTime;

public class CalcularConsumoPorHora {

	private LocalTime tempo;
	private Eletrodomestico eletrodomestico;

	public CalcularConsumoPorHora(LocalTime tempo, Eletrodomestico eletrodomestico) {
		this.tempo = tempo;
		this.eletrodomestico = eletrodomestico;
	}

	public BigDecimal calcular() {
		var horas = this.converterHorasParaDecimal(this.tempo);

		return this.eletrodomestico.getEficienciaEnergetica()
			.getConsumoEnergetico()
			.multiply(horas)
			.divide(BigDecimal.valueOf(1000))
			.multiply(BigDecimal.valueOf(1000)); //Arredondar o valor do KWh
	}

	private BigDecimal converterHorasParaDecimal(LocalTime tempo) {
		return BigDecimal.valueOf(tempo.getHour() + (tempo.getMinute() / 60.0));
	}

}
