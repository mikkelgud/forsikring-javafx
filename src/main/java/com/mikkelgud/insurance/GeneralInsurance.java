
package com.mikkelgud.insurance;

import com.mikkelgud.filehandling.FileObjectEntity;
import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDateTime;

public abstract class GeneralInsurance extends FileObjectEntity implements Observable {
    private static BoatInsurance boatInsurance;
    private static CabinInsurance cabinInsurance;
    private static HouseInsurance houseInsurance;
    private static TravelInsurance travelInsurance;

    private final StringProperty insuranceYearlyPayment = new SimpleStringProperty();
    private final StringProperty insuranceAmount = new SimpleStringProperty();
    private final StringProperty insuranceCoverageInfo = new SimpleStringProperty();

    // Det må finnes en eier av en forsikring.
    private StringProperty personId = new SimpleStringProperty();
    private LocalDateTime createdAt;


    GeneralInsurance(String insuranceYearlyPayment, String insuranceAmount, String insuranceCoverageInfo) {
        this.insuranceAmount.set(insuranceAmount);
        this.insuranceCoverageInfo.set(insuranceCoverageInfo);
        this.insuranceYearlyPayment.set(insuranceYearlyPayment);
        this.createdAt = LocalDateTime.now();
    }

    public GeneralInsurance() {

    }


    public Observable[] getPropertiesAsList(){
        return new Observable[] {
                new SimpleStringProperty("-- GENERELL FORSIKRINGSINFO --"),
                new SimpleStringProperty(String.format("%s", insuranceYearlyPaymentProperty().toString())),
                new SimpleStringProperty(createdAt.toString())
        };
    }


    public StringProperty insuranceYearlyPaymentProperty() {
        return insuranceYearlyPayment;
    }

    public StringProperty insuranceAmountProperty() {
        return insuranceAmount;
    }

    public String getInsuranceCoverageInfo() {
        return insuranceCoverageInfo.get();
    }

    public StringProperty insuranceCoverageInfoProperty() {
        return insuranceCoverageInfo;
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

    public void setPersonId(String personId) {
        this.personId.set(personId);
    }
}
