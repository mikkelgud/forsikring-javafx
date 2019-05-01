
package com.mikkelgud.Insurance;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

import java.time.LocalDateTime;


public class TravelInsurance extends GeneralInsurance {
    private final BooleanProperty europa = new SimpleBooleanProperty();
    private final BooleanProperty asia = new SimpleBooleanProperty();
    private final BooleanProperty nordAmerica = new SimpleBooleanProperty();
    private final BooleanProperty oseania = new SimpleBooleanProperty();
    private final BooleanProperty africa = new SimpleBooleanProperty();
    private final LocalDateTime createdAt;

    public TravelInsurance(String insuranceYearlyPayment, String insuranceAmount, String insuranceCoverageInfo, boolean europa, boolean asia, boolean nordAmerica, boolean oseania, boolean africa) {
        super(insuranceYearlyPayment, insuranceAmount, insuranceCoverageInfo);
        this.africa.set(africa);
        this.europa.set(europa);
        this.asia.set(asia);
        this.nordAmerica.set(nordAmerica);
        this.oseania.set(oseania);
        this.createdAt = LocalDateTime.now();
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public boolean isEuropa() {
        return europa.get();
    }

    public BooleanProperty europaProperty() {
        return europa;
    }

    public boolean isAsia() {
        return asia.get();
    }

    public BooleanProperty asiaProperty() {
        return asia;
    }

    public boolean isNordAmerica() {
        return nordAmerica.get();
    }

    public BooleanProperty nordAmericaProperty() {
        return nordAmerica;
    }

    public boolean isOseania() {
        return oseania.get();
    }

    public BooleanProperty oseaniaProperty() {
        return oseania;
    }

    public boolean isAfrica() {
        return africa.get();
    }

    public BooleanProperty africaProperty() {
        return africa;
    }


}
