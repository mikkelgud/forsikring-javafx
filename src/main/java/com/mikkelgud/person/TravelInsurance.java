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
public class TravelInsurance extends GeneralInsurance{
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
