package com.mikkelgud.person;

import javafx.beans.Observable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PersonListModel {
    private final ObservableList<Person> personList =
            FXCollections.observableArrayList(person -> new Observable[]{
                    person.firstNameProperty(),
                    person.lastNameProperty(),
                    person.billingAddressProperty(),
                    person.insuranceBoatProperty(),
                    person.insuranceCabinProperty(),
                    person.insuranceHouseProperty(),
                    person.insuranceTravelProperty()
            });

    //    This method is not yet in use , but will be helpful when we make the searching method
//    private ObservableList<Person> filteredPersonList = FXCollections.observableArrayList(person -> new Observable[]{
//            person.firstNameProperty(),
//            person.lastNameProperty(),
//            person.billingAddressProperty(),
//            person.insuranceBoatProperty(),
//            person.insuranceCabinProperty(),
//            person.insuranceHouseProperty(),
//            person.insuranceTravelProperty(),
//    });

    private final ObservableList<Observable> currentPersonListAttributes =
            FXCollections.observableArrayList(item -> new Observable[]{item});

    private final ObjectProperty<Person> currentPerson =
            new SimpleObjectProperty<>(null);

    public ObjectProperty<Person> currentPersonProperty() {
        return currentPerson;
    }

    public final Person getCurrentPerson() {
        return currentPersonProperty().get();
    }

    public final void setCurrentPerson(Person person) {
        currentPersonProperty().set(person);
        currentPersonListAttributes.remove(0, currentPersonListAttributes.size());
        currentPersonListAttributes.addAll(person.getPropertiesAsList());
    }

    public ObservableList<Person> getPersonList() {
        return personList;
    }

    public ObservableList<Observable> getCurrentPersonListAttributes() {
        return currentPersonListAttributes;
    }

    //
//    public ObservableList<Person> getFilteredPersonList() {
//        return filteredPersonList;
//    }
//
//    public void setFilteredPersonList(ObservableList<Person> filteredPersonList) {
//        this.filteredPersonList = filteredPersonList;
//    }
//
    @Override
    public String toString(){
        StringBuilder outData = new StringBuilder();
        for(Person personData : getPersonList()){
            outData.append(personData.toString());
        }
        return outData.toString();
    }
}
