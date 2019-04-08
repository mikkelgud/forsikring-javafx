package com.mikkelgud.person;

public class Person {

    private String firstName;
    private String lastName;
    private String billingAddress;

    public Person(String firstName, String lastName, String billingAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.billingAddress = billingAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }
}
