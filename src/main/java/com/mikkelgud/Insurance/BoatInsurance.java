
package com.mikkelgud.Insurance;

import com.mikkelgud.person.Person;

import java.util.ArrayList;
import java.util.Date;


public class BoatInsurance extends GeneralInsurance {

    public String regNr;
    public int year;
    public float boatLength; //ft
    public String[] typeModel;
    public String[] motorTypeHP;
    public Person owner;

    public BoatInsurance(String firstName,
                         String lastName,
                         String billingAddress,
                         float insurancePremium,
                         Date date, float insuranceSalary,
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
