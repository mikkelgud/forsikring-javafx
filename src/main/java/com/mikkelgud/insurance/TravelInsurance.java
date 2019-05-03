
package com.mikkelgud.insurance;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
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

    public TravelInsurance(String insuranceYearlyPayment,
                           String insuranceAmount,
                           String insuranceCoverageInfo,
                           boolean europa,
                           boolean asia,
                           boolean northAmerica,
                           boolean southAmerica,
                           boolean oceania,
                           boolean africa) {

        super(insuranceYearlyPayment, insuranceAmount, insuranceCoverageInfo);
        this.africa.set(africa);
        this.europa.set(europa);
        this.asia.set(asia);
        this.northAmerica.set(northAmerica);
        this.southAmerica.set(southAmerica);
        this.oceania.set(oceania);
        this.createdAt = LocalDateTime.now();
    }

    @Override
    public Observable[] getPropertiesAsList() {

        return new Observable[]{
            new SimpleStringProperty("-- REISEFORSIKRING --"),
            new SimpleStringProperty(isEuropa()),
            new SimpleStringProperty(isAsia()),
            new SimpleStringProperty(isNorthAmerica()),
            new SimpleStringProperty(isSouthAmerica()),
            new SimpleStringProperty(isOceania()),
            new SimpleStringProperty(isAfrica()),
                new SimpleStringProperty(String.format("Opprettet - %s", createdAt.toString())),
            new SimpleStringProperty("----------------------")
        };
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String isEuropa() {
        if(europa.equals(true)){
            return "Forsikret for reiser i Europa";
        } else {
            return "Ikke forsikret for reiser i Europa";
        }
    }

    public BooleanProperty europaProperty() {
        return europa;
    }

    public String isAsia() {
        if(asia.equals(true)) {
            return "Forsikret for reiser i Asia";
        } else {
            return "Ikke forsikret for reiser i Asia";
        }
    }

    public BooleanProperty asiaProperty() {
        return asia;
    }

    public String isNorthAmerica() {
        if(northAmerica.equals(true)){
            return "Forsikret for reiser i Nord Amerika";
        } else {
            return "Ikke forsikret for reiser i Nord Amerika";
        }
    }

    public BooleanProperty northAmericaProperty() {
        return northAmerica;
    }

    public String isSouthAmerica(){
        if(southAmerica.equals(true)){
            return "Forsikret for reiser i Sør Amerika";
        } else{
            return "Ikke forsikret for reiser i Sør Amerika";
        }
    }

    public String isOceania() {
        if(oceania.equals(true)){
            return"Forsikret for reiser i Oseania";
        } else {
            return"Ikke foriskret for reiser i Oseania";
        }
    }

    public BooleanProperty oceaniaProperty() {
        return oceania;
    }

    public String isAfrica() {
        if(africa.equals(true)){
            return "Forsikret for reiser i Afrika";
        } else {
            return "Ikke forsikret for reiser i Afrika";
        }
    }

    public BooleanProperty africaProperty() {
        return africa;
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
