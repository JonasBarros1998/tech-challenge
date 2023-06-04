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

    private final String classification;

    EficienciaEnergeticaClassificacao(String code) {
        this.classification=code;
    }

    @JsonCreator
    public static EficienciaEnergeticaClassificacao decode(final String code) {
        return Stream.of(EficienciaEnergeticaClassificacao.values())
            .filter(targetEnum -> {
                System.out.println(">>> code " + code);
                System.out.println(">>> toString " + targetEnum.classification);
                return targetEnum.classification.equals(code);
            })
                .findFirst()
                .orElseThrow();
    }

    @JsonValue
    public String getCode() {
        return classification;
    }
}
