package com.mikkelgud.claim;

import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ClaimInsuranceModel {

    private final ObservableList<ClaimInsurance> claimedInsurances =
            FXCollections.observableArrayList();

    private StringProperty currentPersonId = new SimpleStringProperty("");


    private final ObservableList<Observable> currentPersonsClaimedInsurances =
            FXCollections.observableArrayList(item -> new Observable[]{item});

    public ObservableList<ClaimInsurance> getAllClaimedInsurances() {
        return claimedInsurances;
    }

    @Override
    public String toString() {
        StringBuilder outData = new StringBuilder();
        for (ClaimInsurance k : getAllClaimedInsurances()) {
            outData.append(k.toString());
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
        this.currentPersonsClaimedInsurances.remove(0, currentPersonsClaimedInsurances.size());

        claimedInsurances.stream().filter(claimInsurance -> claimInsurance.getPersonId().equals(currentPersonId.get())).forEach(currentClaimedInsurance ->
                currentPersonsClaimedInsurances.addAll(currentClaimedInsurance.getPropertiesAsList()));
    }

    public ObservableList<Observable> getCurrentPersonClaims() {
        return currentPersonsClaimedInsurances;
    }
}


