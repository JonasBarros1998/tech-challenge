package br.com.fiap.techchallenge.View.Controller.DTO;

import br.com.fiap.techchallenge.Dominio.enums.EficienciaEnergeticaClassificacao;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record EficienciaEnergeticaDTO(
  @NotNull @PositiveOrZero(message = "deve ser maior que 0") BigDecimal consumoEnergetico,
  @NotNull EficienciaEnergeticaClassificacao classificacao,
  @PositiveOrZero(message = "deve ser maior que 0")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  BigDecimal porcentagemDeEconomia
) {

    public EficienciaEnergeticaDTO(BigDecimal consumoEnergetico, EficienciaEnergeticaClassificacao classificacao) {
        this(consumoEnergetico, classificacao, BigDecimal.ZERO);
    }
}
