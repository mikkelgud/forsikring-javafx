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
    private final StringProperty housingType = new SimpleStringProperty();
    private final StringProperty buildingMaterial = new SimpleStringProperty();
    private final StringProperty housingState = new SimpleStringProperty();
    private final StringProperty builtYear = new SimpleStringProperty();
    private final StringProperty houseSize = new SimpleStringProperty();
    private final StringProperty insuranceBuildingPrice = new SimpleStringProperty();
    private final StringProperty insurancePriceHouseholdGoods = new SimpleStringProperty();
    private final LocalDateTime createdAt;

    protected HouseInsurance(String insuranceYearlyPayment, String insuranceAmount, String insuranceCoverageInfo, String housingAddress, String housingType, String buildingMaterial, String housingState, String builtYear, String squareMeter, String insuranceBP, String insuranceHG) {
        super(insuranceYearlyPayment, insuranceAmount, insuranceCoverageInfo);
        this.createdAt = LocalDateTime.now();
        this.housingAddress.set(housingAddress);
        this.housingType.set(housingType);
        this.buildingMaterial.set(buildingMaterial);
        this.housingState.set(housingState);
        this.builtYear.set(builtYear);
        this.houseSize.set(squareMeter);
        this.insuranceBuildingPrice.set(insuranceBP);
        this.insurancePriceHouseholdGoods.set(insuranceHG);
    }

    public String getHousingAddress() {
        return housingAddress.get();
    }

    public StringProperty housingAddressProperty() {
        return housingAddress;
    }

    public void setHousingAddress(String housingAddress) {
        this.housingAddress.set(housingAddress);
    }

    public String getHousingType() {
        return housingType.get();
    }

    public StringProperty housingTypeProperty() {
        return housingType;
    }

    public void setHousingType(String housingType) {
        this.housingType.set(housingType);
    }

    public String getBuildingMaterial() {
        return buildingMaterial.get();
    }

    public StringProperty buildingMaterialProperty() {
        return buildingMaterial;
    }

    public void setBuildingMaterial(String buildingMaterial) {
        this.buildingMaterial.set(buildingMaterial);
    }

    public String getHousingState() {
        return housingState.get();
    }

    public StringProperty housingStateProperty() {
        return housingState;
    }

    public void setHousingState(String housingState) {
        this.housingState.set(housingState);
    }

    public String getBuiltYear() {
        return builtYear.get();
    }

    public StringProperty builtYearProperty() {
        return builtYear;
    }

    public void setBuiltYear(String builtYear) {
        this.builtYear.set(builtYear);
    }

    public String getHouseSize() {
        return houseSize.get();
    }

    public StringProperty houseSizeProperty() {
        return houseSize;
    }

    public void setHouseSize(String houseSize) {
        this.houseSize.set(houseSize);
    }

    public String getInsuranceBuildingPrice() {
        return insuranceBuildingPrice.get();
    }

    public StringProperty insuranceBuildingPriceProperty() {
        return insuranceBuildingPrice;
    }

    public void setInsuranceBuildingPrice(String insuranceBuildingPrice) {
        this.insuranceBuildingPrice.set(insuranceBuildingPrice);
    }

    public String getInsurancePriceHouseholdGoods() {
        return insurancePriceHouseholdGoods.get();
    }

    public StringProperty insurancePriceHouseholdGoodsProperty() {
        return insurancePriceHouseholdGoods;
    }

    public void setInsurancePriceHouseholdGoods(String insurancePriceHouseholdGoods) {
        this.insurancePriceHouseholdGoods.set(insurancePriceHouseholdGoods);
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public Observable[] getPropertiesAsList() {
        return new Observable[]{
                housingAddressProperty(),
                housingTypeProperty(),
                buildingMaterialProperty(),
                housingStateProperty(),
                builtYearProperty(),
                houseSizeProperty(),
                insuranceBuildingPriceProperty(),
                insurancePriceHouseholdGoodsProperty()
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

