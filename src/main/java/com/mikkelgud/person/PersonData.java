
package com.mikkelgud.person;

public class PersonData {
    private PersonListModel personListModel = new PersonListModel();
    private final PersonValidator validator = new PersonValidator();

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

    public PersonData() {

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
            Person newPerson = validator.createNewPerson(getFirstName(), getLastName(), getBillingAddress());
            personListModel.getPersonList().add(newPerson);
            personListModel.toString();
        } catch (InvalidPersonPropertiesException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String toString() {
        String out = "First name: " + firstName + "Last name: " + lastName + "Billing address: " + billingAddress + "\n";
        System.out.print(out);

        return "First name: " + firstName + "Last name: " + lastName + "Billing address: " + billingAddress + "\n";
    }
}
