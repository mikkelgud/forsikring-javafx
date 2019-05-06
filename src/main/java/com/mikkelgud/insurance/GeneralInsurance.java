
package com.mikkelgud.insurance;

import com.mikkelgud.filehandling.FileObjectEntity;
import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDateTime;

public abstract class GeneralInsurance extends FileObjectEntity implements Observable {
    private final StringProperty insuranceYearlyPayment = new SimpleStringProperty();
    private final StringProperty insuranceAmount = new SimpleStringProperty();
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
                new SimpleStringProperty(String.format("%s", insuranceYearlyPaymentProperty().toString())),
                new SimpleStringProperty(createdAt.toString())
        };
    }

    public StringProperty insuranceYearlyPaymentProperty() {
        return insuranceYearlyPayment;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getPersonId() {
        return personId.get();
    }

    public void setPersonId(String personId) {
        this.personId.set(personId);
    }
}
