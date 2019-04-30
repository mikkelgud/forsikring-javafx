
package com.mikkelgud.Insurance;

import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;

//Denne skal extende generalInsurance, men må dessverre implementere dette senere.
public class BoatInsurance {
    String boatType;
    String model;
    String engineType;
    String enginePower;
    String lenght;

    public String getBoatType() {
        return boatType;
    }


    public String getModel() {
        return model;
    }


    public String getEngineType() {
        return engineType;
    }


    public String getEnginePower() {
        return enginePower;
    }


    public String getLenght() {
        return lenght;
    }


    public BoatInsurance(String boatType, String lenght, String model, String engineType, String enginePower) {
        this.boatType = boatType;
        this.model = model;
        this.engineType = engineType;
        this.enginePower = enginePower;
        this.lenght = lenght;
    }

    public Observable[] getBoatInsurancePropertiesAsList() {
        return new Observable[]{
                new SimpleStringProperty(String.format("Båttype - %s", getBoatType())),
                new SimpleStringProperty(String.format("Båtlengde - %s", getLenght())),
                new SimpleStringProperty(String.format("Båtmodell - %s", getModel())),
                new SimpleStringProperty(String.format("Motortype - %s", getEngineType())),
                new SimpleStringProperty(String.format("Motorkraft - %s", getEnginePower())),
        };
    }



}
