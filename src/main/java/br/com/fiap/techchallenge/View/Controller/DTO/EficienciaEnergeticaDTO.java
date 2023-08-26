package br.com.fiap.techchallenge.View.Controller.DTO;

import br.com.fiap.techchallenge.domain.enums.EficienciaEnergeticaClassificacao;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record EficienciaEnergeticaDTO(
  @NotNull @PositiveOrZero(message = "deve ser maior que 0") BigDecimal consumoEnergetico,
  EficienciaEnergeticaClassificacao classificacao,
  @PositiveOrZero(message = "deve ser maior que 0") BigDecimal porcentagemDeEconomia
) {
    /*
    public EficienciaEnergetica(BigDecimal consumoEnergetico, EficienciaEnergeticaClassificacao classificacao) {
        this(consumoEnergetico, classificacao, BigDecimal.ZERO);
    }*/
}
