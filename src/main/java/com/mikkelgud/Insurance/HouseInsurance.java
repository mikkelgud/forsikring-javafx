/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikkelgud.Insurance;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDateTime;


public class HouseInsurance extends GeneralInsurance {


    private final StringProperty housingAdress = new SimpleStringProperty();
    private final StringProperty housingType = new SimpleStringProperty();
    private final StringProperty buildingMaterial = new SimpleStringProperty();
    private final StringProperty housingState = new SimpleStringProperty();
    private final StringProperty builtYear = new SimpleStringProperty();
    private final StringProperty houseSize = new SimpleStringProperty();
    private final StringProperty insuranceBuildingPrice = new SimpleStringProperty();
    private final StringProperty insurancePriceHouseholdGoods = new SimpleStringProperty();
    private final LocalDateTime createdAt;

    protected HouseInsurance(String insuranceYearlyPayment, String insuranceAmount, String insuranceCoverageInfo, String housingAdress, String housingType, String buildingMaterial, String housingState, String builtYear, String squareMeter, String insuranceBP, String insuranceHG) {
        super(insuranceYearlyPayment, insuranceAmount, insuranceCoverageInfo);
        this.createdAt = LocalDateTime.now();
        this.housingAdress.set(housingAdress);
        this.housingType.set(housingType);
        this.buildingMaterial.set(buildingMaterial);
        this.housingState.set(housingState);
        this.builtYear.set(builtYear);
        this.houseSize.set(squareMeter);
        this.insuranceBuildingPrice.set(insuranceBP);
        this.insurancePriceHouseholdGoods.set(insuranceHG);
    }


    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}

