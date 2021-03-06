
package com.mikkelgud.insurance;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class CabinInsurance extends GeneralInsurance {

    private final StringProperty address = new SimpleStringProperty();
    private final StringProperty buildingType = new SimpleStringProperty();
    private final StringProperty buildingMaterial = new SimpleStringProperty();
    private final StringProperty housingState = new SimpleStringProperty();
    private final StringProperty cabinSize = new SimpleStringProperty();
    private final StringProperty yearBuilt = new SimpleStringProperty();
    private final StringProperty insuranceAmountBuilding = new SimpleStringProperty();
    private final StringProperty insuranceAmountHouseholdGoods = new SimpleStringProperty();
    private LocalDateTime createdAt;

    protected CabinInsurance(String currentPersonId,
                             String insuranceYearlyPayment, String insuranceAmount, String insuranceCoverageInfo, String address, String buildingMaterial,
                             String housingState, String cabinSize, String buildingType, String yearBuilt, String insurancePriceBuilding, String insurancePriceHouseholdGoods) {
        super(insuranceYearlyPayment, insuranceAmount, insuranceCoverageInfo);
        this.createdAt = LocalDateTime.now();
        this.address.set(address);
        this.buildingMaterial.set(buildingMaterial);
        this.housingState.set(housingState);
        this.cabinSize.set(cabinSize);
        this.yearBuilt.set(yearBuilt);
        this.insuranceAmountBuilding.set(insurancePriceBuilding);
        this.insuranceAmountHouseholdGoods.set(insurancePriceHouseholdGoods);
        this.buildingType.set(buildingType);
        setPersonId(currentPersonId);
    }

    public CabinInsurance(){}

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getAddress() {
        return address.get();
    }

    public String getHousingState() {
        return housingState.get();
    }

    public String getCabinSize() {
        return cabinSize.get();
    }

    public String getYearBuilt() {
        return yearBuilt.get();
    }

    public String getBuildingMaterial(){ return  buildingMaterial.get(); }

    public String getInsuranceAmountHouseholdGoods() {
        return insuranceAmountHouseholdGoods.get();
    }

    public String getInsurancePriceBuilding() {
        return insuranceAmountBuilding.get();
    }

    public String getBuildingType() {
        return buildingType.get();
    }


    @Override
    public Observable[] getPropertiesAsList() {
        return new Observable[]{
                new SimpleStringProperty("-- Hytte og innbo --"),
                new SimpleStringProperty(String.format("Kunde - %s", getPersonId())),
                new SimpleStringProperty(String.format("Adresse - %s", getAddress())),
                new SimpleStringProperty(String.format("Bygningstype - %s", getBuildingType())),
                new SimpleStringProperty(String.format("Bygningsmateriale - %s", getBuildingMaterial())),
                new SimpleStringProperty(String.format("Byggeår - %s", getYearBuilt())),
                new SimpleStringProperty(String.format("Tilstand - %s", getHousingState())),
                new SimpleStringProperty(String.format("Størrelse - %s kvadratmeter", getCabinSize())),
                new SimpleStringProperty(String.format("Forsikringspremie bygning - %s", getInsurancePriceBuilding())),
                new SimpleStringProperty(String.format("Forsikringspremie innbo - %s", getInsuranceAmountHouseholdGoods())),
                new SimpleStringProperty(String.format("Opprettet - %s", createdAt.toString())),
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

    @Override
    public List<String> getDeclaredFields() {
        return Arrays.asList(
                "personId",
                "address",
                "buildingType",
                "buildingMaterial",
                "yearBuilt",
                "housingState",
                "cabinSize",
                "insurancePriceBuilding",
                "insurancePriceHouseholdGoods",
                "createdAt"
        );
    }

    @Override
    public List<String> getFieldValues() {
        return Arrays.asList(
                getPersonId(),
                getAddress(),
                getBuildingType(),
                getBuildingMaterial(),
                getYearBuilt(),
                getHousingState(),
                getCabinSize(),
                getInsurancePriceBuilding(),
                getInsuranceAmountHouseholdGoods(),
                getCreatedAt().toString()
        );
    }

    @Override
    public Object getObjectForString(String line) {
        return null;
    }
}


