
package com.mikkelgud.insurance;

import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDateTime;

public abstract class GeneralInsurance implements Observable {
    //forsikringspremie
    private final StringProperty insuranceYearlyPayment = new SimpleStringProperty();
    //Beløpet de er forsikret for
    private final StringProperty insuranceAmount = new SimpleStringProperty();
    // forsikringsbetinglelsene hva den dekker
    private final StringProperty insuranceCoverageInfo = new SimpleStringProperty();

    // Det må finnes en eier av en forsikring.
    private StringProperty personId = new SimpleStringProperty();
    private final LocalDateTime createdAt;

    GeneralInsurance(String insuranceYearlyPayment, String insuranceAmount, String insuranceCoverageInfo) {
        this.insuranceAmount.set(insuranceAmount);
        this.insuranceCoverageInfo.set(insuranceCoverageInfo);
        this.insuranceYearlyPayment.set(insuranceYearlyPayment);
        this.createdAt = LocalDateTime.now();
    }


    public Observable[] getPropertiesAsList(){
        return new Observable[] {
                new SimpleStringProperty("-- GENERELL FORSIKRINGSINFO --"),
                new SimpleStringProperty(String.format("Totalt forsikringsbeløp: %s", getInsuranceAmount())),
                new SimpleStringProperty(String.format("Årlig fakturering: %s", getInsuranceYearlyPayment()))
        };
    }

    public String getInsuranceYearlyPayment() {
        //insuranceYearlyPayment =null;
        return insuranceYearlyPayment.get();
    }

    public StringProperty insuranceYearlyPaymentProperty() {
        return insuranceYearlyPayment;
    }

    public String getInsuranceAmount() {
        return insuranceAmount.get();
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
