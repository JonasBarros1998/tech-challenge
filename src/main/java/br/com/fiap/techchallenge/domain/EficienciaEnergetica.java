package br.com.fiap.techchallenge.domain;

import br.com.fiap.techchallenge.domain.enums.EficienciaEnergeticaClassificacao;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class EficienciaEnergetica {

    @NotNull
    @DecimalMin(value = "0")
    BigDecimal consumoEnergetico;

    @NotNull
    EficienciaEnergeticaClassificacao classificacao;

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

}
