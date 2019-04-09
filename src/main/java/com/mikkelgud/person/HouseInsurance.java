/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikkelgud.person;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author alexanderbjorlo
 */
public class HouseInsurance extends GeneralInsurance {
    public String housingAddress;
    public int builtYear;
    public String housingType;
    public String buildingMaterial;
    public String housingState;
    public int squareMeter;
    public float insurancePriceBuilding;
    public float insurancePriceHouseholdGoods;
    public HouseInsurance(String firstName, String lastName, String billingAddress, 
            float insurancePremium, Date date, float insuranceSalary, 
            ArrayList insuranceInfo, String housingAddress, int builtYear,
            String housingType, String buildingMaterial, String housingState,
            int squareMeter, float insurancePriceBuilding, 
            float insurancePriceHouseholdGoods) {
        super(firstName, lastName, billingAddress, insurancePremium, 
                date, insuranceSalary, insuranceInfo);
        this.housingAddress = housingAddress;
        this.builtYear = builtYear;
        this.housingType = housingType;
        this.buildingMaterial = buildingMaterial;
        this.housingState = housingState;
        this.squareMeter = squareMeter;
        this.insurancePriceBuilding = insurancePriceBuilding;
        this.insurancePriceHouseholdGoods = insurancePriceHouseholdGoods;
        
    }
    
}
