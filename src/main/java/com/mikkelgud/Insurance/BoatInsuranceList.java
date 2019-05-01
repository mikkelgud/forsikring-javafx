package com.mikkelgud.Insurance;


import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BoatInsuranceList {
    private final ObservableList<BoatInsurance> boatInsuranceList = FXCollections.observableArrayList(BoatInsurance -> new Observable[]{
            BoatInsurance.boatTypeProperty(),
            BoatInsurance.modelProperty(),
            BoatInsurance.LengthProperty(),
            BoatInsurance.engineTypeProperty(),
            BoatInsurance.enginePowerProperty()
    });

    public ObservableList<BoatInsurance> getBoatInsuranceList() {
        return boatInsuranceList;
    }


    @Override
    public String toString() {
        StringBuilder outData = new StringBuilder();
        for (BoatInsurance boatInsuranceData : getBoatInsuranceList()) {
            outData.append(boatInsuranceData.toString());
        }
        return outData.toString();
    }
}