package com.mikkelgud.claimForm;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDateTime;

public class ClaimInsurance {
    private final StringProperty damageType = new SimpleStringProperty();
    private final StringProperty dateOfRegistration = new SimpleStringProperty();
    private final StringProperty descriptionOfDamage = new SimpleStringProperty();
    private final StringProperty taxationValue = new SimpleStringProperty();
    private final StringProperty witnesses = new SimpleStringProperty();
    private final StringProperty moneyBack = new SimpleStringProperty();
    private final LocalDateTime createdAt;

    public ClaimInsurance(String damageType, String dateOfRegistration, String descriptionOfDamage, String taxationValue, String witnesses, String moneyBack) {
        this.createdAt = LocalDateTime.now();
        this.damageType.set(damageType);
        this.dateOfRegistration.set(descriptionOfDamage);
        this.descriptionOfDamage.set(descriptionOfDamage);
        this.taxationValue.set(taxationValue);
        this.witnesses.set(witnesses);
        this.moneyBack.set(moneyBack);
    }
}
