
package com.mikkelgud.insurance;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

import java.time.LocalDateTime;


public class TravelInsurance extends GeneralInsurance {
    private final BooleanProperty europa = new SimpleBooleanProperty();
    private final BooleanProperty asia = new SimpleBooleanProperty();
    private final BooleanProperty northAmerica = new SimpleBooleanProperty();
    private final BooleanProperty oceania = new SimpleBooleanProperty();
    private final BooleanProperty africa = new SimpleBooleanProperty();
    private final LocalDateTime createdAt;

    public TravelInsurance(String insuranceYearlyPayment, String insuranceAmount, String insuranceCoverageInfo, boolean europa, boolean asia, boolean northAmerica, boolean oceania, boolean africa) {
        super(insuranceYearlyPayment, insuranceAmount, insuranceCoverageInfo);
        this.africa.set(africa);
        this.europa.set(europa);
        this.asia.set(asia);
        this.northAmerica.set(northAmerica);
        this.oceania.set(oceania);
        this.createdAt = LocalDateTime.now();
    }

    @Override
    public Observable[] getPropertiesAsList() {
        return new Observable[]{
                europa,
                asia,
                northAmerica,
                oceania,
                africa,
        };
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

    public boolean getNorthAmerica() {
        return northAmerica.get();
    }

    public BooleanProperty northAmericaProperty() {
        return northAmerica;
    }

    public boolean getOceania() {
        return oceania.get();
    }

    public BooleanProperty oceaniaProperty() {
        return oceania;
    }

    public boolean isAfrica() {
        return africa.get();
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
