
package com.mikkelgud.insurance;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDateTime;


public class TravelInsurance extends GeneralInsurance {
    private final BooleanProperty europa = new SimpleBooleanProperty();
    private final BooleanProperty asia = new SimpleBooleanProperty();
    private final BooleanProperty northAmerica = new SimpleBooleanProperty();
    private final BooleanProperty oceania = new SimpleBooleanProperty();
    private final BooleanProperty africa = new SimpleBooleanProperty();
    private final BooleanProperty southAmerica = new SimpleBooleanProperty();
    private final LocalDateTime createdAt;

    private final String MESSAGE_IS = "";
    private final String MESSAGE_IS_NOT = "IKKE";

    public TravelInsurance(String currentPersonId, String insuranceYearlyPayment, String insuranceAmount, String insuranceCoverageInfo, boolean europa, boolean asia, boolean northAmerica, boolean southAmerica, boolean oceania, boolean africa) {
        super(insuranceYearlyPayment, insuranceAmount, insuranceCoverageInfo);
        this.africa.set(africa);
        this.europa.set(europa);
        this.asia.set(asia);
        this.northAmerica.set(northAmerica);
        this.southAmerica.set(southAmerica);
        this.oceania.set(oceania);
        this.createdAt = LocalDateTime.now();
        setPersonId(currentPersonId);
    }

    @Override
    public Observable[] getPropertiesAsList() {
        return new Observable[]{
            new SimpleStringProperty("-- REISEFORSIKRING --"),
                new SimpleStringProperty("Registrerte foriskringssteder"),
                new SimpleStringProperty(String.format("Europa er %s registrert", getEuropeBooleanAsString())),
                new SimpleStringProperty(String.format("Oseania er %s registrert", getOseaniaBooleanAsString())),
                new SimpleStringProperty(String.format("Asia er %s registrert", getAsiaBooleanAsString())),
                new SimpleStringProperty(String.format("Afrika er %s registrert", getAfricaaBooleanAsString())),
                new SimpleStringProperty(String.format("Søramerika er %s registrert", getSouthAmericaBooleanAsString())),
                new SimpleStringProperty(String.format("NordAmerica er %s registrert", getNorthAmericaBooleanAsString())),
                new SimpleStringProperty(String.format("Opprettet - %s registrert", createdAt.toString())),
            new SimpleStringProperty("----------------------")
        };
    }

    public boolean isEuropa() {
        return europa.get();
    }

    public boolean isAsia() {
        return asia.get();
    }

    public boolean isNorthAmerica() {
        return northAmerica.get();
    }

    public boolean isOceania() {
        return oceania.get();
    }

    public boolean isAfrica() {
        return africa.get();
    }

    public boolean isSouthAmerica() {
        return southAmerica.get();
    }

    public String getOseaniaBooleanAsString() {
        return isOceania() ? MESSAGE_IS : MESSAGE_IS_NOT;
    }

    public String getAfricaaBooleanAsString() {
        return isAfrica() ? MESSAGE_IS : MESSAGE_IS_NOT;
    }

    public String getSouthAmericaBooleanAsString() {
        return isSouthAmerica() ? MESSAGE_IS : MESSAGE_IS_NOT;
    }

    public String getEuropeBooleanAsString() {
        return isEuropa() ? MESSAGE_IS : MESSAGE_IS_NOT;
    }

    public String getNorthAmericaBooleanAsString() {
        return isNorthAmerica() ? MESSAGE_IS : MESSAGE_IS_NOT;
    }

    private String getAsiaBooleanAsString() {
        return isAsia() ? MESSAGE_IS : MESSAGE_IS_NOT;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
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
