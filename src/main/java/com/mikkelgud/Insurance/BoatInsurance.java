
package com.mikkelgud.insurance;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDateTime;

public class BoatInsurance extends GeneralInsurance {
    private final StringProperty boatType = new SimpleStringProperty();
    private final StringProperty model = new SimpleStringProperty();
    private final StringProperty engineType = new SimpleStringProperty();
    private final StringProperty enginePower = new SimpleStringProperty();
    private final StringProperty length = new SimpleStringProperty();
    private final LocalDateTime createdAt;

    public BoatInsurance(String currentPersonId, String insuranceYearlyPayment, String insuranceAmount, String insuranceCoverageInfo, String boatType, String length, String model, String engineType, String enginePower) {
        super(insuranceYearlyPayment, insuranceAmount, insuranceCoverageInfo);
        this.createdAt = LocalDateTime.now();
        this.boatType.set(boatType);
        this.model.set(model);
        this.engineType.set(engineType);
        this.enginePower.set(enginePower);
        this.length.set(length);
        setPersonId(currentPersonId);
    }

    public String getBoatType() {
        return boatType.get();
    }

    public String getModel() {
        return model.get();
    }

    public String getEngineType() {
        return engineType.get();
    }

    public String getEnginePower() {
        return enginePower.get();
    }

    public String getLength() {
        return length.get();
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public StringProperty boatTypeProperty() {
        return boatType;
    }

    public StringProperty lengthProperty() {
        return length;
    }

    public StringProperty modelProperty() {
        return model;
    }

    public StringProperty engineTypeProperty() {
        return engineType;
    }

    public StringProperty enginePowerProperty() {
        return enginePower;
    }

    public void setBoatType(String boatType) {
        this.boatType.set(boatType);
    }

    public void setModel(String model) {
        this.model.set(model);
    }

    public void setEngineType(String engineType) {
        this.engineType.set(engineType);
    }

    public void setEnginePower(String enginePower) {
        this.enginePower.set(enginePower);
    }

    public void setLength(String length) {
        this.length.set(length);
    }

    @Override
    public Observable[] getPropertiesAsList() {
        return new Observable[]{
                new SimpleStringProperty("-- BÅTFORSIKRING --"),
                new SimpleStringProperty(String.format("Kunde - %s", getPersonId())),
                new SimpleStringProperty(String.format("Båttype - %s", getBoatType())),
                new SimpleStringProperty(String.format("Båtlengde - %s", getLength())),
                new SimpleStringProperty(String.format("Båtmodell - %s", getModel())),
                new SimpleStringProperty(String.format("Motortype - %s", getEngineType())),
                new SimpleStringProperty(String.format("Motorkraft - %s", getEnginePower())),
                new SimpleStringProperty(String.format("Opprettet -  %s", createdAt.toString())),
                new SimpleStringProperty("-------------------")
        };
    }

    @Override
    public void addListener(InvalidationListener invalidationListener) {
        invalidationListener.invalidated(this);
    }

    @Override
    public void removeListener(InvalidationListener invalidationListener) {
        invalidationListener.invalidated(this);
    }
}
