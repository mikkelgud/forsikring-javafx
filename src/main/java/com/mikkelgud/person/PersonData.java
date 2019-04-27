/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikkelgud.person;

/**
 *
 * @author alexanderbjorlo
 */
public class PersonData {
    public String firstName;
    public String lastName;
    public String billingAddress;
    
    public PersonData(
            String firstName,
            String lastName,
            String billingAddress
    ){
      this.firstName = firstName;
      this.lastName = lastName;
      this.billingAddress = billingAddress;
    }
    
    @Override
    public String toString(){
        String out = "First name: " + firstName + "Last name: " + lastName + "Billing address: " + billingAddress;
        System.out.print(out);
        return "First name: " + firstName + "Last name: " + lastName + "Billing address: " + billingAddress;
    }
    
}
