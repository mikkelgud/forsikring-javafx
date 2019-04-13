/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikkelgud.Insurance;

import com.mikkelgud.person.Person;

import java.util.ArrayList;
import java.util.Date;

public abstract class GeneralInsurance extends Person {
    public float insurancePremium;
    public float insuranceSalary;
    public ArrayList insuranceInfo;
    public Date date;

    public GeneralInsurance(String firstName, String lastName,
                            String billingAddress, float insurancePremium, Date date,
                            float insuranceSalary, ArrayList insuranceInfo) {
        super(firstName, lastName, billingAddress);
        this.insurancePremium = insurancePremium;
        this.date = date;
        this.insuranceSalary = insuranceSalary;
        this.insuranceInfo = insuranceInfo;
    }


}
