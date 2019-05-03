
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


    public boolean isCabinProperty() {
        return cabinProperty;
    }

    public void setHouseProperty(boolean houseProperty) {
        this.houseProperty = houseProperty;
    }

    public void setCabinProperty(boolean cabinProperty) {
        this.cabinProperty = cabinProperty;
    }

    public void setBoatProperty(boolean boatProperty) {
        this.boatProperty = boatProperty;
    }

    public void setTravelProperty(boolean travelProperty) {
        this.travelProperty = travelProperty;
    }

    public void setPersonListModel(PersonListModel personListModel) {
        this.personListModel = personListModel;
    }

    public PersonListModel getPersonListModel() {
        return personListModel;
    }

    public PersonValidator getValidator() {
        return validator;
    }

    public boolean isHouseProperty() {
        return houseProperty;
    }

    public boolean isBoatProperty() {
        return boatProperty;
    }

    public boolean isTravelProperty() {
        return travelProperty;
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

    //public void attatchToGUI(){
    //    try {
    //        Person newPerson = validator.createNewPerson(getFirstName(), getLastName(), getBillingAddress());
    //        personListModel.getPersonList().add(newPerson);

    //    } catch (InvalidPersonPropertiesException ex) {
    //        ex.printStackTrace();
    //    }
    //}


