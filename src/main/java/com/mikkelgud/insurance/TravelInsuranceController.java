package com.mikkelgud.insurance;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class TravelInsuranceController {
    @FXML
    public CheckBox southAmerica;
    @FXML
    public CheckBox northAmerica;
    @FXML
    public CheckBox asia;
    @FXML
    public CheckBox oseania;
    @FXML
    public CheckBox africa;
    @FXML
    public CheckBox europe;
    @FXML
    public Label insuranceYearlyPaymentOutPrint;
    @FXML
    public Label insuranceAmountOutPrint;
    @FXML
    public Label InsuranceCoverageInfoOutPrint;
    @FXML
    public Label errorLabel;
    @FXML
    public Button registrateTravel;

    private final String insuranceYearlyPayment = "1000 kroner";
    private final String insuranceAmount = "3000000 kroner";
    private final String insuranceCoverage = "Dekker all skade i forbindelse med Reise til utland innenfor forsikrede områder.";

    private final InsuranceValidator validator = new InsuranceValidator();

    private InsurancesModel insurancesModel;

    public void registrateTravelInsurance(ActionEvent event){
        try{
            TravelInsurance newTravelInsurance = validator.createNewTravelInsurance(insurancesModel.getCurrentPersonId(), insuranceYearlyPayment, insuranceAmount, insuranceCoverage, southAmerica.isSelected(), northAmerica.isSelected(), asia.isSelected(), oseania.isSelected(), africa.isSelected(), europe.isSelected());
            insurancesModel.getAllInsurances().add(newTravelInsurance);

            closePage();
        } catch (InvalidInsurancePropertiesException e) {
            errorLabel.setText(e.getMessage());
        }
    }

    private void closePage() {
        Stage stage = (Stage) registrateTravel.getScene().getWindow();
        stage.close();
    }

    public void setInsurancesModel(InsurancesModel insurancesModel) {
        this.insurancesModel = insurancesModel;
    }

    public void getPrintImportantInformation() {
        insuranceYearlyPaymentOutPrint.setText(insuranceYearlyPayment);
        insuranceAmountOutPrint.setText(insuranceAmount);
        InsuranceCoverageInfoOutPrint.setText(insuranceCoverage);
    }
}
