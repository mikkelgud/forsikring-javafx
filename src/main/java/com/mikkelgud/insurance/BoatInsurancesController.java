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
    @FXML
    public Label insuranceYearlyPaymentOutPrint;
    @FXML
    public Label insuranceAmountOutPrint;
    @FXML
    public Label insuranceCoverageInfoOutPrint;


    private final String insuranceYearlyPayment = "1000";
    private final String insuranceAmount = "300 000";
    private final String insuranceCoverage = "Dekker all skade i forbindelse med din båt på vannet eller under henholdsmessig frakt.";

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

    public void getPrintImportantInformation() {
        insuranceYearlyPaymentOutPrint.setText(insuranceYearlyPayment);
        insuranceAmountOutPrint.setText(insuranceAmount);
        insuranceCoverageInfoOutPrint.setText(insuranceCoverage);
    }
}
