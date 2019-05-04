package com.mikkelgud.claimForm;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDateTime;

public class ClaimInsurance implements Observable {
    private final StringProperty damageType = new SimpleStringProperty();
    private final StringProperty dateOfRegistration = new SimpleStringProperty();
    private final StringProperty descriptionOfDamage = new SimpleStringProperty();
    private final StringProperty taxationValue = new SimpleStringProperty();
    private final StringProperty witnesses = new SimpleStringProperty();
    private final StringProperty moneyBack = new SimpleStringProperty();
    private StringProperty personId = new SimpleStringProperty();
    private final LocalDateTime createdAt;

    public ClaimInsurance(String personId, String damageType, String dateOfRegistration, String descriptionOfDamage, String taxationValue, String witnesses, String moneyBack) {
        setPersonId(personId);
        this.createdAt = LocalDateTime.now();
        this.damageType.set(damageType);
        this.dateOfRegistration.set(dateOfRegistration);
        this.descriptionOfDamage.set(descriptionOfDamage);
        this.taxationValue.set(taxationValue);
        this.witnesses.set(witnesses);
        this.moneyBack.set(moneyBack);
    }


    public void setPersonId(String personId) {
        this.personId.set(personId);
    }

    public String getDamageType() {
        return damageType.get();
    }

    public StringProperty damageTypeProperty() {
        return damageType;
    }

    public String getDateOfRegistration() {
        return dateOfRegistration.get();
    }

    public StringProperty dateOfRegistrationProperty() {
        return dateOfRegistration;
    }

    public String getDescriptionOfDamage() {
        return descriptionOfDamage.get();
    }

    public StringProperty descriptionOfDamageProperty() {
        return descriptionOfDamage;
    }

    public String getTaxationValue() {
        return taxationValue.get();
    }

    public StringProperty taxationValueProperty() {
        return taxationValue;
    }

    public String getWitnesses() {
        return witnesses.get();
    }

    public StringProperty witnessesProperty() {
        return witnesses;
    }

    public String getMoneyBack() {
        return moneyBack.get();
    }

    public StringProperty moneyBackProperty() {
        return moneyBack;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getPersonId() {
        return personId.get();
    }

    public StringProperty personIdProperty() {
        return personId;
    }


    public Observable[] getPropertiesAsList() {
        return new Observable[]{
                new SimpleStringProperty(String.format("Skadetype- %s", getDamageType())),
                new SimpleStringProperty(String.format("Hendelsesdato %s", getDateOfRegistration()))
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
