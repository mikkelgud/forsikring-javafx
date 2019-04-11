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
public class CabinInsurance extends GeneralInsurance{
    public String adress;
    public int yearBuilt;
    public String buildingMaterial;
    public String housingState;
    public String squareMeter;
    public float insurancePriceBuilding;
    public float insurancePriceHouseholdGoods;
    public CabinInsurance(String firstName, String lastName, String billingAddress, 
            float insurancePremium, Date date, float insuranceSalary, 
            ArrayList insuranceInfo, String adress, int yearBuilt, String buildingMaterial,
            String housingState, String squareMeter, float insurancePriceBuilding,
            float insurancePriceHouseholdGoods) {
        super(firstName, lastName, billingAddress, insurancePremium, 
                date, insuranceSalary, insuranceInfo);
        this.adress = adress;
        this.yearBuilt = yearBuilt;
        this.buildingMaterial = buildingMaterial;
        this.housingState = housingState;
        this.squareMeter = squareMeter;
        this.insurancePriceBuilding = insurancePriceBuilding;
        this.insurancePriceHouseholdGoods = insurancePriceHouseholdGoods;
        
    }
    

    
    
}
