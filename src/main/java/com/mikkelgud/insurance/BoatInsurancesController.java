package com.mikkelgud.insurance;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BoatInsurancesController {
    @FXML
    public TextField boatType;
    @FXML
    public TextField length;
    @FXML
    public TextField modelYear;
    @FXML
    public TextField engineType;
    @FXML
    public TextField enginePower;
    @FXML
    private Label errorLabel;

    private String insuranceYearlyPayment = "12123+";
    private String insuranceAmount = "300 000";
    private String insuranceCoverage = "Dekker all skade med båt";

    private final String EMPTY_STRING = "";

    private final InsuranceValidator validator = new InsuranceValidator();

    private InsurancesModel insurancesModel;

    @FXML
    private void registerBoatInsurance(ActionEvent event) {
        errorLabel.setText("");
        try {
            BoatInsurance newBoatInsurance = validator.createNewBoatInsurance(
                    insurancesModel.getCurrentPersonId(),
                    insuranceYearlyPayment,
                    insuranceAmount,
                    insuranceCoverage,
                    boatType.getText(),
                    length.getText(),
                    modelYear.getText(),
                    engineType.getText(),
                    enginePower.getText());

            insurancesModel.getAllInsurances().add(newBoatInsurance);
            resetFieldValues();
        } catch (InvalidInsurancePropertiesException ex) {
            errorLabel.setText(ex.getMessage());
        }
    }

    private void resetFieldValues() {
        boatType.setText(EMPTY_STRING);
        length.setText(EMPTY_STRING);
        modelYear.setText(EMPTY_STRING);
        engineType.setText(EMPTY_STRING);
        enginePower.setText(EMPTY_STRING);
    }

    public void setInsurancesModel(InsurancesModel insurancesModel) {
        this.insurancesModel = insurancesModel;
    }
}
