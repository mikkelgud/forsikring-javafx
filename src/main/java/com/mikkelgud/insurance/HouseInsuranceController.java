package com.mikkelgud.insurance;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    @FXML
    public Label insuranceYearlyPaymentOutPrint;
    @FXML
    public Label insuranceAmountOutPrint;
    @FXML
    public Label InsuranceCoverageInfoOutPrint;
    @FXML
    public Button registrateHousing;


    private String insuranceYearlyPayment = "500 000";
    // skal være summen av insuranceBP og HG
    private String insuranceAmount = "300 000";
    private String insuranceCoverage = "Dekker skade med innbo og bygningsmasse";

    // disse skal komme inn fra bruker og regnese ut
//    private int parsedInsuranceBP = Integer.parseInt(getInsurancePremiumBuilding().getCharacters().toString());
//    private int parsedInsuranceHG = Integer.parseInt(insurancePremiumInnbo.getCharacters().toString());

//    private int sum = getParsedInsuranceBP() + getParsedInsuranceHG();

    private final String EMPTY_STRING = "";

    private final InsuranceValidator validator = new InsuranceValidator();

    private InsurancesModel insurancesModel;

    @FXML
    private void registrateInsurance(ActionEvent event) {
        errorLabel.setText("");
        try {
            //Må kjøre denne testen her da den valideringen ikke fungerer om ikke det er gjort noe med den
            if (buildingMaterial.getValue() == null || houseType.getValue() == null) {
//                System.out.println(sum);
                throw new InvalidInsurancePropertiesException("Husk at alle feltene må fylles ut før registrering");
            } else {
                HouseInsurance newHouseInsurance = validator.createNewHouseInsurance(insurancesModel.getCurrentPersonId(),
                        insuranceYearlyPayment,
                        insuranceAmount,
                        insuranceCoverage,
                        homeAddress.getText(),
                        yearBuilt.getText(),
                        housingSize.getText(),
                        insurancePremiumBuilding.getText(),
                        insurancePremiumInnbo.getText(),
                        houseType.getValue().toString(),
                        buildingMaterial.getValue().toString());
                insurancesModel.getAllInsurances().add(newHouseInsurance);
                resetFieldValues();
                closePage();
            }
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

    private void closePage() {
        Stage stage = (Stage) registrateHousing.getScene().getWindow();
        stage.close();
    }

    public void getPrintImportantInformation() {
        System.out.print(insuranceYearlyPayment);
        System.out.print(insuranceAmount);
        System.out.print(insuranceCoverage);
        insuranceYearlyPaymentOutPrint.setText(insuranceYearlyPayment);
        insuranceAmountOutPrint.setText(insuranceAmount);
        InsuranceCoverageInfoOutPrint.setText(insuranceCoverage);
    }

    public TextField getInsurancePremiumBuilding() {
        return insurancePremiumBuilding;
    }

    public TextField getInsurancePremiumInnbo() {
        return insurancePremiumInnbo;
    }
//    public int getParsedInsuranceBP() {
//        return parsedInsuranceBP;
//    }
//
//    public int getParsedInsuranceHG() {
//        return parsedInsuranceHG;
//    }
}

