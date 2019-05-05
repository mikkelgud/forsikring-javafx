package com.mikkelgud.insurance;

import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class InsurancesModel {

    private final ObservableList<GeneralInsurance> allInsurances =
            FXCollections.observableArrayList();

    private StringProperty currentPersonId = new SimpleStringProperty("");


    private final ObservableList<Observable> currentPersonsInsurances =
            FXCollections.observableArrayList(item -> new Observable[]{item});

    public ObservableList<GeneralInsurance> getAllInsurances() {
        return allInsurances;
    }

    @Override
    public String toString() {
        StringBuilder outData = new StringBuilder();
        for (GeneralInsurance insurance : getAllInsurances()) {
            outData.append(insurance.toString());
        }
        return outData.toString();
    }

    public String getCurrentPersonId() {
        return currentPersonId.get();
    }

    public void setCurrentPersonId(String currentPersonId) {
        this.currentPersonId.set(currentPersonId);
    }

    public void setCurrentPersonsInsurances() {
        this.currentPersonsInsurances.remove(0, currentPersonsInsurances.size());

        allInsurances.stream().filter(insurance -> insurance.getPersonId().equals(currentPersonId.get())).forEach(currentPersonInsurance ->
                currentPersonsInsurances.addAll(currentPersonInsurance.getPropertiesAsList()));
    }

    public ObservableList<Observable> getCurrentPersonsInsurances() {
        return currentPersonsInsurances;
    }
}
