package com.mikkelgud.insurance;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class HouseInsuranceController {

    @FXML
    public TextField housingSize;
    @FXML
    public TextField insurancePremiumBuilding;
    @FXML
    public TextField insurancePremiumInnbo;
    @FXML
    public ComboBox houseType;
    @FXML
    public ComboBox buildingMaterial;

    private String insuranceYearlyPayment = "12123+";
    private String insuranceAmount = "300 000";
    private String insuranceCoverage = "Dekker all skade med båt";
    private String insuranceBP = "300 000";
    private String insuranceHG = "100 000";
    

    private final String EMPTY_STRING = "";

    private final InsuranceValidator validator = new InsuranceValidator();

    private InsurancesModel insurancesModel;

    @FXML
    private void registrateInsurance(ActionEvent event) throws InvalidInsurancePropertiesException {
        // HouseInsurance newHouseInsurance = validator.createNewHouseInsurance(insurancesModel.getCurrentPersonId(),
        //       );

    }
}
