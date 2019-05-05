
package com.mikkelgud.person;

public class PersonData {
    private PersonListModel personListModel = new PersonListModel();
    private final PersonValidator validator = new PersonValidator();

    public String firstName;
    public String lastName;
    public String billingAddress;
    public boolean houseProperty;
    public boolean cabinProperty;
    public boolean boatProperty;
    public boolean travelProperty;

    public PersonData(String firstName,
                      String lastName,
                      String billingAddress,
                      boolean houseProperty,
                      boolean cabinProperty,
                      boolean boatProperty,
                      boolean travelProperty) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.billingAddress = billingAddress;
        this.houseProperty = houseProperty;
        this.cabinProperty = cabinProperty;
        this.boatProperty = boatProperty;
        this.travelProperty = travelProperty;
    }

    @Override
    public String toString() {
        return "PersonData{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", billingAddress='" + billingAddress + '\'' +
                ", houseProperty=" + houseProperty +
                ", cabinProperty=" + cabinProperty +
                ", boatProperty=" + boatProperty +
                ", travelProperty=" + travelProperty +
                '}';
    }
}


