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


    private final String insuranceYearlyPayment = "1000 kroner";
    private final String insuranceAmount = "1800000 kroner";
    private final String insuranceCoverage = "Dekker skade på Fritidsboligtomten. Skade som skjer inne i boligen. Skader som skjer oppstår i forbindelse med boligen ";
    private final String insurancePremiumBuilding = "1000000 kroner";
    private final String insurancePremiumHousing = "800000 kroner";

    private final String EMPTY_STRING = "";
    private final String MESSAGE_FILL_OUT_ALL_FIELDS = "Vennligs påse at alle utfyllingsfeltene er fylt ut";

    private final InsuranceValidator validator = new InsuranceValidator();

    private InsurancesModel insurancesModel;

    @FXML
    public void registerCabinInsurance() {
        errorLabel.setText(EMPTY_STRING);
        //Må kjøre denne testen her da dette vil gi en nullpointer exeption i validatoren.
        if (buildingMaterial.getValue() == null || standard.getValue() == null || buildingType.getValue() == null) {
            errorLabel.setText(MESSAGE_FILL_OUT_ALL_FIELDS);
        } else {
            try {
                CabinInsurance newCabinInsurance = validator.createNewCabinInsurance(insurancesModel.getCurrentPersonId(), insuranceYearlyPayment, insuranceAmount, insuranceCoverage, adress.getText(), buildingMaterial.getValue().toString(), standard.getValue().toString(), cabinSize.getText(), buildingType.getValue().toString(), yearBuilt.getText(), insurancePremiumBuilding, insurancePremiumHousing);
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
