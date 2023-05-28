package br.com.fiap.techchallenge.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum EnergyEfficiencyClassification {

    A("A"),
    B("B"),
    C("C"),
    D("D"),
    E("E"),
    F("F"),
    G("G");

    private final String classification;

    EnergyEfficiencyClassification(String code) {
        this.classification=code;
    }

    @JsonCreator
    public static EnergyEfficiencyClassification decode(final String code) {
        return Stream.of(EnergyEfficiencyClassification.values())
                    .filter(targetEnum -> targetEnum.classification.equals(code))
                        .findFirst()
                        .orElseThrow();
    }

    @JsonValue
    public String getCode() {
        return classification;
    }
}
