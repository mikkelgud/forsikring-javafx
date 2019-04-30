
package com.mikkelgud.Insurance;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

// will soooooon extends GeneralInsurance, but for now, sorry bro fix me if you can.

public class CabinInsurance {

    private final StringProperty adress = new SimpleStringProperty();
    private final StringProperty buildingMaterial = new SimpleStringProperty();
    private final StringProperty housingState = new SimpleStringProperty();
    private final StringProperty squareMeter = new SimpleStringProperty();
    private final StringProperty yearBuilt = new SimpleStringProperty();
    private final StringProperty insurancePriceBuilding = new SimpleStringProperty();
    private final StringProperty insurancePriceHouseholdGoods = new SimpleStringProperty();

    public CabinInsurance(String adress, String buildingMaterial, String housingState) {
        this.adress.set(adress);
    }
}
