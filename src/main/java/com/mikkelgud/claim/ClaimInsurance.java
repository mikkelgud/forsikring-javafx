package com.mikkelgud.claim;

import com.mikkelgud.filehandling.FileObjectEntity;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class ClaimInsurance extends FileObjectEntity implements Observable {

    private final int insuranceId;
    private final StringProperty damageType = new SimpleStringProperty();
    private final StringProperty dateOfRegistration = new SimpleStringProperty();
    private final StringProperty descriptionOfDamage = new SimpleStringProperty();
    private final StringProperty taxationValue = new SimpleStringProperty();
    private final StringProperty witnesses = new SimpleStringProperty();
    private final StringProperty moneyBack = new SimpleStringProperty();
    private StringProperty personId = new SimpleStringProperty();
    private final LocalDateTime createdAt;

    public ClaimInsurance(int insuranceId, String personId, String damageType, String dateOfRegistration, String descriptionOfDamage, String taxationValue, String witnesses, String moneyBack) {
        setPersonId(personId);
        this.createdAt = LocalDateTime.now();
        this.damageType.set(damageType);
        this.dateOfRegistration.set(dateOfRegistration);
        this.descriptionOfDamage.set(descriptionOfDamage);
        this.taxationValue.set(taxationValue);
        this.witnesses.set(witnesses);
        this.moneyBack.set(moneyBack);
        this.insuranceId = insuranceId;
    }

    public void setPersonId(String personId) {
        this.personId.set(personId);
    }

    public String getDamageType() {
        return damageType.getValue();
    }

    public StringProperty damageTypeProperty() {
        return damageType;
    }

    public String getDateOfRegistration() {
        return dateOfRegistration.getValue();
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

    public String getCreatedAtAsString() {
        return createdAt.toString();
    }

    public String getPersonId() {
        return personId.get();
    }

    public StringProperty personIdProperty() {
        return personId;
    }


    public Observable[] getPropertiesAsList() {
        return new Observable[]{
                new SimpleStringProperty(String.format("-- Registrert skade %d --", insuranceId)),
                new SimpleStringProperty(String.format("PersonID- %s", getPersonId())),
                new SimpleStringProperty(String.format("Registreringsdato- %s", getCreatedAtAsString())),
                new SimpleStringProperty(String.format("Skadetype- %s", getDamageType())),
                new SimpleStringProperty(String.format("Hendelsesdato %s", getDateOfRegistration())),
                new SimpleStringProperty(String.format("Beskrivelse: %s", getDescriptionOfDamage())),
                new SimpleStringProperty(String.format("Vitner- %s", getWitnesses())),
                new SimpleStringProperty(String.format("Takstert til- %s kroner", getTaxationValue())),
                new SimpleStringProperty(String.format("Du får utbetalt - %s kroner", getMoneyBack())),
                new SimpleStringProperty("-----------------------------")
        };
    }

    @Override
    public List<String> getDeclaredFields() {
        return Arrays.asList(
                "personId",
                "createdAt",
                "damageType",
                "dateOfRegistration",
                "descriptionOfDamage",
                "witnesses",
                "taxationValue",
                "moneyBack"
        );
    }

    @Override
    public List<String> getFieldValues() {
        return Arrays.asList(
                Integer.toString(insuranceId),
                getPersonId(),
                getCreatedAtAsString(),
                getDamageType(),
                getDateOfRegistration(),
                getDescriptionOfDamage(),
                getWitnesses(),
                getTaxationValue(),
                getMoneyBack()
        );
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
