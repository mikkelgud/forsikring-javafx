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
        String out = "First name: " + firstName + "Last name: " + lastName + "Billing address: " + billingAddress + "\n";
        System.out.print(out);
        return "First name: " + firstName + "Last name: " + lastName + "Billing address: " + billingAddress +"\n";
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getBillingAddress() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void attatchToGUI(){

        try {
            PersonValidator validator = new PersonValidator();
            Person newPerson = validator.createNew(getFirstName(), getLastName(), getBillingAddress());


            PersonListModel personListModel = new PersonListModel();
            personListModel.getPersonList().add(newPerson);

        } catch (InvalidPersonPropertiesException ex) {

        }
    }
}
