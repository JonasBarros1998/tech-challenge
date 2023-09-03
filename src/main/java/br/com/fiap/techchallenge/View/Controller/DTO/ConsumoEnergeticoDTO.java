package br.com.fiap.techchallenge.View.Controller.DTO;

import java.math.BigDecimal;
import java.time.LocalTime;

public record ConsumoEnergeticoDTO(
	LocalTime tempoDeUso,

	BigDecimal consumoEnergeticoPorHora
) {}
