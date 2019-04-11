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
public class BoatInsurance extends GeneralInsurance{
    public Person owner;
    public String regNr;
    public String[] typeModel;
    public float boatLength; //ft
    public int year;
    public String[] motorTypeHP;
    
    public BoatInsurance(String firstName, String lastName, String billingAddress, 
            float insurancePremium, Date date, float insuranceSalary, 
            ArrayList insuranceInfo, Person owner, String regNr, String[] typeModel,
            float boatLength, int year, String[] motorTypeHP) {
        super(firstName, lastName, billingAddress, insurancePremium, date, insuranceSalary, insuranceInfo);
        this.owner = owner;
        this.regNr = regNr;
        this.typeModel = typeModel;
        this.boatLength = boatLength;
        this.year = year;
        this.motorTypeHP = motorTypeHP;
    }
    
    
}
