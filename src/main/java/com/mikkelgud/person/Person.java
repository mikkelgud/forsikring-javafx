package com.mikkelgud.person;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {

    private final StringProperty firstName = new SimpleStringProperty();
    private final StringProperty lastName = new SimpleStringProperty();
    private final StringProperty billingAddress = new SimpleStringProperty();

    private final BooleanProperty insuranceHouse = new SimpleBooleanProperty();
    private final BooleanProperty insuranceTravel = new SimpleBooleanProperty();
    private final BooleanProperty insuranceCabin = new SimpleBooleanProperty();
    private final BooleanProperty insuranceBoat = new SimpleBooleanProperty();

    public Person(String firstName, String lastName, String billingAddress) {
        this.firstName.set(firstName);
        this.lastName.set(lastName);
        this.billingAddress.set(billingAddress);
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
        return String.format("Navn: %s %s, Adresse: %s", getFirstName(), getLastName(), getBillingAddress());
    }
}
