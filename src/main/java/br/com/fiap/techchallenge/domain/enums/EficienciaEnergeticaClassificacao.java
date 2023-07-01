package br.com.fiap.techchallenge.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum EficienciaEnergeticaClassificacao {

    A("A"),
    B("B"),
    C("C"),
    D("D"),
    E("E"),
    F("F"),
    G("G");

    private final String classificacao;

    EficienciaEnergeticaClassificacao(String code) {
        this.classificacao =code;
    }

    @JsonCreator
    public static EficienciaEnergeticaClassificacao decode(final String code) {
        return Stream.of(EficienciaEnergeticaClassificacao.values())
            .filter(targetEnum -> targetEnum.classificacao.equals(code))
                .findFirst()
                .orElseThrow();
    }

    @JsonValue
    public String getCode() {
        return classificacao;
    }
}
