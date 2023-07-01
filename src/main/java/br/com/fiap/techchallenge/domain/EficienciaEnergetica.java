package br.com.fiap.techchallenge.domain;

import br.com.fiap.techchallenge.domain.enums.EficienciaEnergeticaClassificacao;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public class EficienciaEnergetica {

    @NotNull
    @PositiveOrZero(message = "deve ser maior que 0")
    BigDecimal consumoEnergetico;

    @NotNull
    EficienciaEnergeticaClassificacao classificacao;


    @Nullable
    @PositiveOrZero(message = "deve ser maior que 0")
    BigDecimal porcentagemDeEconomia;

    public EficienciaEnergetica(BigDecimal consumo, EficienciaEnergeticaClassificacao eficienciaEnergetica) {
        this.consumoEnergetico = consumo;
        this.classificacao = eficienciaEnergetica;
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
