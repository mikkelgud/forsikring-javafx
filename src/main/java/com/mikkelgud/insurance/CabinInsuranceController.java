package com.mikkelgud.insurance;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
    TextField extraStandardInfo;
    @FXML
    TextField cabinSize;
    @FXML
    TextField insurancePremiumBuilding;
    @FXML
    TextField insurancePremiumHousing;
    @FXML
    ComboBox buildingType;
    @FXML
    protected Label insuranceYearlyPaymentOutPrint;
    @FXML
    protected Label inuranceAmountOutPrint;
    @FXML
    protected Label InsuranceCoverageInfoOutPrint;

    private String insuranceYearlyPayment = "12123+";
    private String insuranceAmount = "300 000";
    private String insuranceCoverage = "Dekker skade med innbo og bygningsmasse";

    private final String EMPTY_STRING = "";

    private final InsuranceValidator validator = new InsuranceValidator();

    private InsurancesModel insurancesModel;

    @FXML
    public void registerCabinInsurance() {
       // errorLabel.setText()
        try{
            CabinInsurance newCabinInsurance = validator.createNewCabinInsurance(insurancesModel.getCurrentPersonId(),
                    insuranceYearlyPayment, insuranceAmount, insuranceCoverage, adress.getText(), buildingMaterial.getValue().toString(),
                    standard.getValue().toString(),
                    cabinSize.getText(), insurancePremiumBuilding.getText(), insurancePremiumHousing.getText(),
                    buildingType.getValue().toString());
        } catch(InvalidInsurancePropertiesException ex){

        }
      //  errorLabel.setText(ex.getMessage());
    }
}
