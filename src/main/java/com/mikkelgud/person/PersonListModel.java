package com.mikkelgud.person;

import javafx.beans.Observable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PersonListModel {
    private final ObservableList<Person> personList = FXCollections.observableArrayList(person ->
            new Observable[]{person.firstNameProperty(), person.lastNameProperty(), person.billingAddressProperty(),
                    person.insuranceBoatProperty(), person.insuranceCabinProperty(), person.insuranceHouseProperty(),
                    person.insuranceTravelProperty()
            });

    private final ObjectProperty<Person> currentPerson = new SimpleObjectProperty<>(null);

    public ObjectProperty<Person> currentPersonProperty() {
        return currentPerson;
    }

    public final Person getCurrentPerson() {
        return currentPersonProperty().get();
    }

    public final void setCurrentPerson(Person person) {
        currentPersonProperty().set(person);
    }

    public ObservableList<Person> getPersonList() {
        return personList;
    }


}