package com.mikkelgud.insurance;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HouseInsuranceController {

    @FXML
    public TextField homeAddress;
    @FXML
    public TextField yearBuilt;
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
    @FXML
    public Label errorLabel;

    private String insuranceYearlyPayment = "12123+";
    private String insuranceAmount = "300 000";
    private String insuranceCoverage = "Dekker skade med innbo og bygningsmasse";
    private String insuranceBP = "300 000";
    private String insuranceHG = "100 000";


    private final String EMPTY_STRING = "";

    private final InsuranceValidator validator = new InsuranceValidator();

    private InsurancesModel insurancesModel;

    @FXML
    private void registrateInsurance(ActionEvent event) throws InvalidInsurancePropertiesException {
        errorLabel.setText("");
        try {
            HouseInsurance newHouseInsurance = validator.createNewHouseInsurance(insurancesModel.getCurrentPersonId(),
                    insuranceYearlyPayment, insuranceAmount, insuranceCoverage, homeAddress.getText(), yearBuilt.getText(),
                    housingSize.getText(),  insurancePremiumBuilding.getText(), insurancePremiumInnbo.getText(),
                    houseType.getValue().toString(), buildingMaterial.getValue().toString()

            );
            insurancesModel.getAllInsurances().add(newHouseInsurance);
            resetFieldValues();
        }catch (InvalidInsurancePropertiesException ex) {
            errorLabel.setText(ex.getMessage());
        }
    }
    private void resetFieldValues() {
        homeAddress.setText(EMPTY_STRING);
        yearBuilt.setText(EMPTY_STRING);
        housingSize.setText(EMPTY_STRING);
        insurancePremiumBuilding.setText(EMPTY_STRING);
        insurancePremiumInnbo.setText(EMPTY_STRING);
        houseType.getSelectionModel().clearAndSelect(0);
        buildingMaterial.getSelectionModel().clearAndSelect(0);
    }
    public void setInsurancesModel(InsurancesModel insurancesModel) {
        this.insurancesModel = insurancesModel;
    }
}
