/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikkelgud.Insurance;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

//extends GeneralInsurance kommer snart  ;O
public class HouseInsurance {
//    p String housingAddress;
//    public String housingType;
//    public String buildingMaterial;
//    public String housingState;
//    public int builtYear;
//    public int squareMeter;
//    public float insurancePriceBuilding;
//    public float insurancePriceHouseholdGoods;

    private final StringProperty housingAdress = new SimpleStringProperty();
    private final StringProperty housingType = new SimpleStringProperty();
    private final StringProperty buildingMaterial = new SimpleStringProperty();
    private final StringProperty housingState = new SimpleStringProperty();
    private final StringProperty builtYear = new SimpleStringProperty();
    private final StringProperty squareMeter = new SimpleStringProperty();
    private final StringProperty insuranceBuildingPrice = new SimpleStringProperty();
    private final StringProperty insurancePriceHouseholdGoods = new SimpleStringProperty();

    public HouseInsurance(String housingAdress, String housingType, String buildingMaterial, String housingState, String builtYear, String squareMeter) {
    }

    //
//    public HouseInsurance(
//            String firstName,
//            String lastName,
//            String billingAddress,
//            String housingAddress,
//            String housingType,
//            String buildingMaterial,
//            String housingState,
//            int squareMeter,
//            int builtYear,
//            float insurancePremium,
//            float insurancePriceBuilding,
//            float insuranceSalary,
//            float insurancePriceHouseholdGoods,
//            Date date,
//            ArrayList insuranceInfo) {
//        super(firstName, lastName, billingAddress, insurancePremium, date, insuranceSalary, insuranceInfo);
//        this.housingAddress = housingAddress;
//        this.builtYear = builtYear;
//        this.housingType = housingType;
//        this.buildingMaterial = buildingMaterial;
//        this.housingState = housingState;
//        this.squareMeter = squareMeter;
//        this.insurancePriceBuilding = insurancePriceBuilding;
//        this.insurancePriceHouseholdGoods = insurancePriceHouseholdGoods;
    }
    

