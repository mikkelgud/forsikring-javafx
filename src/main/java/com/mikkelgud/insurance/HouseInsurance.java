/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikkelgud.insurance;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDateTime;


public class HouseInsurance extends GeneralInsurance {


    private final StringProperty housingAddress = new SimpleStringProperty();
    private final StringProperty yearBuilt = new SimpleStringProperty();
    private final StringProperty housingType = new SimpleStringProperty();
    private final StringProperty buildingMaterial = new SimpleStringProperty();
    private final StringProperty housingState = new SimpleStringProperty();
    private final StringProperty builtYear = new SimpleStringProperty();
    private final StringProperty houseSize = new SimpleStringProperty();
    private final StringProperty insuranceBuildingPrice = new SimpleStringProperty();
    private final StringProperty insurancePriceHouseholdGoods = new SimpleStringProperty();
    private final LocalDateTime createdAt;

    protected HouseInsurance(String currentPersonId, String insuranceYearlyPayment, String insuranceAmount, String insuranceCoverageInfo,
                             String housingAddress, String yearBuilt, String housingType, String buildingMaterial, String housingState,
                             String builtYear, String squareMeter, String insuranceBP, String insuranceHG) {
        super(insuranceYearlyPayment, insuranceAmount, insuranceCoverageInfo);
        this.createdAt = LocalDateTime.now();
        this.housingAddress.set(housingAddress);
        this.yearBuilt.set(yearBuilt);
        this.housingType.set(housingType);
        this.buildingMaterial.set(buildingMaterial);
        this.housingState.set(housingState);
        this.builtYear.set(builtYear);
        this.houseSize.set(squareMeter);
        this.insuranceBuildingPrice.set(insuranceBP);
        this.insurancePriceHouseholdGoods.set(insuranceHG);
        setPersonId(currentPersonId);
    }

    public String getHousingAddress() {
        return housingAddress.get();
    }

    public String getHousingType() {
        return housingType.get();
    }

    public String getBuiltYear() {
        return builtYear.get();
    }

    public String getHouseSize() {
        return houseSize.get();
    }

    public String getInsuranceBuildingPrice() {
        return insuranceBuildingPrice.get();
    }

    public String getInsurancePriceHouseholdGoods() {
        return insurancePriceHouseholdGoods.get();
    }

    public double getHousingInsuranceYearlyPayment(){
        return (Integer.parseInt(getInsurancePriceHouseholdGoods())+Integer.parseInt(getInsurancePriceHouseholdGoods()))*0.05;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public Observable[] getPropertiesAsList() {
        return new Observable[]{
                new SimpleStringProperty("-- Hus og innbo --"),
                new SimpleStringProperty(String.format("Kunde - %s", getPersonId())),
                new SimpleStringProperty(String.format("Adresse - %s", getHousingAddress())),
                new SimpleStringProperty(String.format("Byggeår - %s", getBuiltYear())),
                new SimpleStringProperty(String.format("Type - %s", getHousingType())),
                new SimpleStringProperty(String.format("Størrelse - %s", getHouseSize())),
                new SimpleStringProperty(String.format("Forsikringspremie bygning - %s", getInsuranceBuildingPrice())),
                new SimpleStringProperty(String.format("Forsikringspremie innbo - %s", getInsurancePriceHouseholdGoods())),
                new SimpleStringProperty(String.format("Opprettet -  %s", createdAt.toString())),
                new SimpleStringProperty("-------------------")

        };
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

