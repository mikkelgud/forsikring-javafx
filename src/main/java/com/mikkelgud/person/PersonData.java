
package com.mikkelgud.person;


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
        return "First name: " + firstName + "Last name: " + lastName + "Billing address: " + billingAddress;
    }
    
}
