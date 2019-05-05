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
    public Label insuranceAmountBuildingOutPrint;
    @FXML
    public Label insuranceAmountHouseOutPrint;
    @FXML
    public ComboBox houseType;
    @FXML
    public ComboBox buildingMaterial;
    @FXML
    public Label errorLabel;
    @FXML
    public Label insuranceYearlyPaymentOutPrint;
    @FXML
    public Label insuranceCoverageInfoOutPrint;
    @FXML
    public Button registrateHousing;
    @FXML
    public ComboBox standard;

    private final String insuranceYearlyPayment = "5000";
    private final String insuranceAmount = "2000000";
    private final String insuranceCoverage = "Dekker skade på all eindom som er registrert som din hjemadresse. Dekker uheldige skader som for eksempel flom, brann osv...";
    private final String insuranceAmountHousing = "600000";
    private final String insuranceAmountBuilding = "1400000";

    private final String EMPTY_STRING = "";
    private final String MESSAGE_FILL_OUT_ALL_FIELDS = "Vennligs påse at alle utfyllingsfeltene er fylt ut";

    private final InsuranceValidator validator = new InsuranceValidator();

    private InsurancesModel insurancesModel;

    @FXML
    private void registrateInsurance(ActionEvent event) {
        errorLabel.setText(EMPTY_STRING);
        try {
            //Må kjøre denne testen her da dette vil gi en nullpointer exeption i validatoren.
            if (buildingMaterial.getValue() == null || houseType.getValue() == null || standard.getValue() == null) {
                throw new InvalidInsurancePropertiesException(MESSAGE_FILL_OUT_ALL_FIELDS);
            } else {
                HouseInsurance newHouseInsurance = validator.createNewHouseInsurance(insurancesModel.getCurrentPersonId(), insuranceYearlyPayment, insuranceAmount, insuranceCoverage, homeAddress.getText(), yearBuilt.getText(), houseType.getValue().toString(), buildingMaterial.getValue().toString(), standard.getValue().toString(), housingSize.getText());
                insurancesModel.getAllInsurances().add(newHouseInsurance);
                closePage();
            }
        }catch (InvalidInsurancePropertiesException ex) {
            errorLabel.setText(ex.getMessage());
        }
    }


    public void setInsurancesModel(InsurancesModel insurancesModel) {
        this.insurancesModel = insurancesModel;
    }

    private void closePage() {
        Stage stage = (Stage) registrateHousing.getScene().getWindow();
        stage.close();
    }

    public void getPrintImportantInformation() {
        insuranceYearlyPaymentOutPrint.setText(insuranceYearlyPayment);
        insuranceAmountBuildingOutPrint.setText(insuranceAmountBuilding);
        insuranceAmountHouseOutPrint.setText(insuranceAmountHousing);
        insuranceCoverageInfoOutPrint.setText(insuranceCoverage);
    }

}

