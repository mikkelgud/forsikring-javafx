package com.mikkelgud.person;

import com.mikkelgud.filehandling.FileObjectEntity;
import javafx.beans.Observable;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Person extends FileObjectEntity {
    private final StringProperty personId = new SimpleStringProperty();
    private final StringProperty firstName = new SimpleStringProperty();
    private final StringProperty lastName = new SimpleStringProperty();
    private final StringProperty billingAddress = new SimpleStringProperty();

    private final BooleanProperty insuranceHouse = new SimpleBooleanProperty();
    private final BooleanProperty insuranceTravel = new SimpleBooleanProperty();
    private final BooleanProperty insuranceCabin = new SimpleBooleanProperty();
    private final BooleanProperty insuranceBoat = new SimpleBooleanProperty();
    private final LocalDateTime createdAt;

    private final String USER_IS_REGISTERED = "Registrert";
    private final String USER_IS_NOT_REGISTERED = "Ikke registrert";


    public Person(String firstName, String lastName, String billingAddress) {
        this.firstName.set(firstName);
        this.lastName.set(lastName);
        this.billingAddress.set(billingAddress);
        //Når vi registrerer en ny person vil dette lagre registreringsdatoen til personen.
        this.createdAt = LocalDateTime.now();
        // Når vi registrerer en ny person, vil denne gi personen en "unik" identifikator.
        this.personId.set(UUID.randomUUID().toString());
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

    public boolean isInsuranceHouse() {
        return insuranceHouse.get();
    }

    public boolean isInsuranceTravel() {
        return insuranceTravel.get();
    }

    public boolean isInsuranceCabin() {
        return insuranceCabin.get();
    }

    public boolean isInsuranceBoat() {
        return insuranceBoat.get();
    }

    public String getInsuranceHouseBooleanAsString() {
        return isInsuranceHouse() ? USER_IS_REGISTERED : USER_IS_NOT_REGISTERED;
    }

    public String getInsuranceCabinBooleanAsString() {
        return isInsuranceCabin() ? USER_IS_REGISTERED : USER_IS_NOT_REGISTERED;
    }

    public String getInsuranceTravelBooleanAsString() {
        return isInsuranceTravel() ? USER_IS_REGISTERED : USER_IS_NOT_REGISTERED;
    }

    public String getInsuranceBoatBooleanAsString() {
        return isInsuranceBoat() ? USER_IS_REGISTERED : USER_IS_NOT_REGISTERED;
    }

    public String getPersonId() {
        return personId.get();
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
                new SimpleStringProperty(String.format("Kundenummer - %s", getPersonId())),
                new SimpleStringProperty(String.format("Fornavn - %s", getFirstName())),
                new SimpleStringProperty(String.format("Etternavn - %s", getLastName())),
                new SimpleStringProperty(String.format("Fakturaadresse - %s", getBillingAddress())),
                new SimpleStringProperty(String.format("Opprettet -  %s", getCreatedAt().toString())),
                new SimpleStringProperty(String.format("Husforsikring - %s", getInsuranceHouseBooleanAsString())),
                new SimpleStringProperty(String.format("Fritidsboligforsikring - %s", getInsuranceCabinBooleanAsString())),
                new SimpleStringProperty(String.format("Båtforsikring - %s", getInsuranceBoatBooleanAsString())),
                new SimpleStringProperty(String.format("Reiseforsikring - %s", getInsuranceTravelBooleanAsString()))
        };
    }


    @Override
    public List<String> getDeclaredFields() {
        return Arrays.asList(
                "personId",
                "firstName",
                "lastName",
                "billingAddress",
                "insuranceHouse",
                "insuranceCabin",
                "insuranceBoat",
                "insuranceTravel",
                "createdAt"
        );
    }

    @Override
    public List<String> getFieldValues() {
        return Arrays.asList(
                getPersonId(),
                getFirstName(),
                getLastName(),
                getBillingAddress(),
                Boolean.toString(isInsuranceHouse()),
                Boolean.toString(isInsuranceCabin()),
                Boolean.toString(isInsuranceBoat()),
                Boolean.toString(isInsuranceTravel()),
                getCreatedAt().toString()
        );
    }
}

