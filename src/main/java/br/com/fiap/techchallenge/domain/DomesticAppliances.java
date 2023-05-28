package br.com.fiap.techchallenge.domain;

import br.com.fiap.techchallenge.domain.enums.EnergyEfficiencyClassification;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class DomesticAppliances {

    @NotEmpty
    private final String name;

    @NotEmpty
    private final String model;

    @DecimalMin(value = "0")
    private final BigDecimal power;

    @DecimalMin(value = "0")
    private final BigDecimal volts;

    @NotEmpty
    private final String brand;

    @NotNull
    private EnergyEfficiencyClassification energyEfficiency;

    public DomesticAppliances(
            String name,
            String model,
            BigDecimal power,
            BigDecimal volts,
            String brand,
            EnergyEfficiencyClassification energyEficiency
    ) {
        this.name = name;
        this.model = model;
        this.power = power;
        this.volts = volts;
        this.brand = brand;
        this.energyEfficiency = energyEficiency;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public BigDecimal getPower() {
        return power;
    }

    public BigDecimal getVolts() {
        return volts;
    }

    public String getBrand() {
        return brand;
    }

    public EnergyEfficiencyClassification getEnergyEfficiency() {
        return this.energyEfficiency;
    }

}
