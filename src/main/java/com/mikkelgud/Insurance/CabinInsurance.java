
package com.mikkelgud.Insurance;

import java.util.ArrayList;
import java.util.Date;

public class CabinInsurance extends GeneralInsurance {
    public String adress;
    public String buildingMaterial;
    public String housingState;
    public String squareMeter;
    public int yearBuilt;
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
