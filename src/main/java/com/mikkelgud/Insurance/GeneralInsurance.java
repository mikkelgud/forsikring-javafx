
package com.mikkelgud.Insurance;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDateTime;

public abstract class GeneralInsurance {
    private StringProperty insuranceYearlyPayment = new SimpleStringProperty();
    private StringProperty insuranceAmount = new SimpleStringProperty();
    private StringProperty insuranceCoverageInfo = new SimpleStringProperty();
    private final LocalDateTime createdAt;

    public abstract LocalDateTime getCreatedAt();


    protected GeneralInsurance(String insuranceYearlyPayment, String insuranceAmount, String insuranceCoverageInfo) {
        this.insuranceAmount.set(insuranceAmount);
        this.insuranceCoverageInfo.set(insuranceCoverageInfo);
        this.insuranceYearlyPayment.set(insuranceYearlyPayment);
        this.createdAt = LocalDateTime.now();
    }


    public String getInsuranceYearlyPayment() {
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

}
