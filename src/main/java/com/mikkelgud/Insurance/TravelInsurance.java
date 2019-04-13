
package com.mikkelgud.Insurance;

import java.util.ArrayList;
import java.util.Date;

public class TravelInsurance extends GeneralInsurance {
    public String insuranceRegion;
    public float insurancePremiumTravel;
    public TravelInsurance(String firstName, String lastName, String billingAddress,
            float insurancePremium, Date date, float insuranceSalary,
            ArrayList insuranceInfo, String insuranceRegion) {
        super(firstName, lastName, billingAddress, insurancePremium, date, 
                insuranceSalary, insuranceInfo);
        this.insuranceRegion = insuranceRegion;
        this.insurancePremium = insurancePremium;
    }
    
}
