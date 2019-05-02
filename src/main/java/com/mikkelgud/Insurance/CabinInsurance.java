
package com.mikkelgud.insurance;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDateTime;

public class CabinInsurance extends GeneralInsurance {

    private final StringProperty address = new SimpleStringProperty();
    private final StringProperty buildingMaterial = new SimpleStringProperty();
    private final StringProperty housingState = new SimpleStringProperty();
    private final StringProperty cabinSize = new SimpleStringProperty();
    private final StringProperty yearBuilt = new SimpleStringProperty();
    private final StringProperty insurancePriceBuilding = new SimpleStringProperty();
    private final StringProperty insurancePriceHouseholdGoods = new SimpleStringProperty();
    private final LocalDateTime createdAt;
//    private final StringProperty insuranceAmount = new SimpleStringProperty();
//    private final StringProperty insuranceCoverageInfo = new SimpleStringProperty();
//    private final StringProperty insuranceYearlyPayment =  new SimpleStringProperty();



    protected CabinInsurance(String insuranceYearlyPayment, String insuranceAmount, String insuranceCoverageInfo, String address, String buildingMaterial, String housingState, String cabinSize, String yearBuilt, String insurancePriceBuilding, String insurancePriceHouseholdGoods) {
        super(insuranceYearlyPayment, insuranceAmount, insuranceCoverageInfo);
        this.createdAt = LocalDateTime.now();
        this.address.set(address);
        this.buildingMaterial.set(buildingMaterial);
        this.housingState.set(housingState);
        this.cabinSize.set(cabinSize);
        this.yearBuilt.set(yearBuilt);
        this.insurancePriceBuilding.set(insurancePriceBuilding);
        this.insurancePriceHouseholdGoods.set(insurancePriceHouseholdGoods);
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }


    public String getAddress() {
        return address.get();
    }

    public StringProperty addressProperty() {
        return address;
    }

    public String getBuildingMaterial() {
        return buildingMaterial.get();
    }

    public StringProperty buildingMaterialProperty() {
        return buildingMaterial;
    }

    public String getHousingState() {
        return housingState.get();
    }

    public StringProperty housingStateProperty() {
        return housingState;
    }

    public String getCabinSize() {
        return cabinSize.get();
    }

    public StringProperty cabinSizeProperty() {
        return cabinSize;
    }

    public String getYearBuilt() {
        return yearBuilt.get();
    }

    public StringProperty yearBuiltProperty() {
        return yearBuilt;
    }

    public String getInsurancePriceBuilding() {
        return insurancePriceBuilding.get();
    }

    public StringProperty insurancePriceBuildingProperty() {
        return insurancePriceBuilding;
    }

    public String getInsurancePriceHouseholdGoods() {
        return insurancePriceHouseholdGoods.get();
    }

    public StringProperty insurancePriceHouseholdGoodsProperty() {
        return insurancePriceHouseholdGoods;
    }

    @Override
    public Observable[] getPropertiesAsList() {
        return new Observable[]{
                address,
                buildingMaterial,
                housingState,
                cabinSize,
                yearBuilt,
                insurancePriceBuilding,
                insurancePriceHouseholdGoods
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


