package com.mikkelgud.Insurance;

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
    public TextField model;
    @FXML
    public TextField engineType;
    @FXML
    public TextField enginePower;
    @FXML
    private Label errorLabel;


    private String insuranceYearlyPayment = "12123+";
    private String insuranceAmount = "300 000";
    private String insuranceCoverage = "Dekker all skade med båt";

    private final InsuranceValidator validator = new InsuranceValidator();

    private BoatInsuranceList boatInsuranceList;


    @FXML
    private void registrateBoatInsuranceButtonHandeler(ActionEvent event) {
        errorLabel.setText("");
        try {
            BoatInsurance newBoatInsurance = validator.createNewBoatInsurance(insuranceYearlyPayment, insuranceAmount, insuranceCoverage, boatType.getText(), length.getText(), model.getText(), engineType.getText(), enginePower.getText());
            boatInsuranceList.getBoatInsuranceList().addAll(newBoatInsurance);

        } catch (InvalidInsurancePropertiesException ex) {
            errorLabel.setText(ex.getMessage());
        }
    }


    public void setBoatInsuranceList(BoatInsuranceList boatInsuranceList) {
        this.boatInsuranceList = boatInsuranceList;
    }
}
