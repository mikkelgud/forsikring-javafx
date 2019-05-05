package com.mikkelgud.insurance;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class CabinInsuranceController {
    @FXML
    TextField adress;
    @FXML
    TextField yearBuilt;
    @FXML
    ComboBox buildingMaterial;
    @FXML
    ComboBox standard;
    @FXML
    TextArea extraStandardInfo;
    @FXML
    TextField cabinSize;
    @FXML
    ComboBox buildingType;
    @FXML
    Button registrateCabin;
    @FXML
    public Label errorLabel;
    @FXML
    public Label insuranceYearlyPaymentOutPrint;
    @FXML
    public Label insuranceAmountBuildingOutPrint;
    @FXML
    public Label insuranceAmountHouseOutPrint;
    @FXML
    public Label insuranceCoverageInfoOutPrint;


    private final String insuranceYearlyPayment = "1000";
    private final String insuranceAmount = "1800000";
    private final String insuranceCoverage = "Dekker skade på Fritidsboligtomten. Skade som skjer inne i boligen. Skader som skjer oppstår i forbindelse med boligen ";
    private final String insurancePremiumBuilding = "1000000";
    private final String insurancePremiumHousing = "800000";

    private final String EMPTY_STRING = "";

    private final InsuranceValidator validator = new InsuranceValidator();

    private InsurancesModel insurancesModel;

    @FXML
    public void registerCabinInsurance() {
        errorLabel.setText("");
        if (buildingMaterial.getValue() == null || standard.getValue() == null || buildingType.getValue() == null) {
            errorLabel.setText("fyll inn alt ellers blir det bare kluss");
        } else {
            try {
                CabinInsurance newCabinInsurance = validator.createNewCabinInsurance(
                        insurancesModel.getCurrentPersonId(),
                        insuranceYearlyPayment,
                        insuranceAmount,
                        insuranceCoverage,
                        adress.getText(),
                        buildingMaterial.getValue().toString(),
                        standard.getValue().toString(),
                        cabinSize.getText(),
                        buildingType.getValue().toString(),
                        yearBuilt.getText(),
                        insurancePremiumBuilding,
                        insurancePremiumHousing);
                insurancesModel.getAllInsurances().add(newCabinInsurance);
                closePage();
            } catch (InvalidInsurancePropertiesException ex) {
                errorLabel.setText(ex.getMessage());
            }
        }
    }

    private void closePage() {
        Stage stage = (Stage) registrateCabin.getScene().getWindow();
        stage.close();
    }

    public void setInsurancesModel(InsurancesModel insurancesModel) {
        this.insurancesModel = insurancesModel;
    }

    public void getPrintImportantInformation() {
        insuranceYearlyPaymentOutPrint.setText(insuranceYearlyPayment);
        insuranceAmountHouseOutPrint.setText(insurancePremiumHousing);
        insuranceAmountBuildingOutPrint.setText(insurancePremiumBuilding);
        insuranceCoverageInfoOutPrint.setText(insuranceCoverage);
    }
}
