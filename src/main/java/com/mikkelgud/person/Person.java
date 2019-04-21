package com.mikkelgud.person;

import javafx.beans.Observable;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDateTime;

public class Person {

    private final StringProperty firstName = new SimpleStringProperty();
    private final StringProperty lastName = new SimpleStringProperty();
    private final StringProperty billingAddress = new SimpleStringProperty();

    private final BooleanProperty insuranceHouse = new SimpleBooleanProperty();
    private final BooleanProperty insuranceTravel = new SimpleBooleanProperty();
    private final BooleanProperty insuranceCabin = new SimpleBooleanProperty();
    private final BooleanProperty insuranceBoat = new SimpleBooleanProperty();
    private final LocalDateTime createdAt;

    public Person(String firstName, String lastName, String billingAddress) {
        this.firstName.set(firstName);
        this.lastName.set(lastName);
        this.billingAddress.set(billingAddress);
        this.createdAt = LocalDateTime.now();
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getBillingAddress() {
        return billingAddress.get();
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public StringProperty billingAddressProperty() {
        return billingAddress;
    }

    public BooleanProperty insuranceHouseProperty() {
        return insuranceHouse;
    }

    public BooleanProperty insuranceTravelProperty() {
        return insuranceTravel;
    }

    public BooleanProperty insuranceBoatProperty() {
        return insuranceBoat;
    }

    public BooleanProperty insuranceCabinProperty() {
        return insuranceCabin;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress.set(billingAddress);
    }

    public void setInsuranceHouse(boolean isInsured) {
        this.insuranceHouse.set(isInsured);
    }


    public void setInsuranceTravel(boolean isInsured) {
        this.insuranceTravel.set(isInsured);
    }

    public void setInsuranceCabin(boolean isInsured) {
        this.insuranceCabin.set(isInsured);
    }

    public void setInsuranceBoat(boolean isInsured) {
        this.insuranceBoat.set(isInsured);
    }

    @Override
    public String toString() {
        return String.format("%s %s",  getFirstName(), getLastName());
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Observable[] getPropertiesAsList() {
        return new Observable[]{
                new SimpleStringProperty(String.format("Fornavn - %s", getFirstName())),
                new SimpleStringProperty(String.format("Etternavn - %s", getLastName())),
                new SimpleStringProperty(String.format("Fakturaadresse - %s", getBillingAddress())),
                new SimpleStringProperty(String.format("Opprettet -  %s", getCreatedAt().toString())),
        };
    }
}
