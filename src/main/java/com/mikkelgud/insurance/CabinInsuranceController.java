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
    @FXML
    Label errorLabel;

    private String insuranceYearlyPayment = "12123+";
    private String insuranceAmount = "300 000";
    private String insuranceCoverage = "Dekker skade med innbo og bygningsmasse";

    private final String EMPTY_STRING = "";

    private final InsuranceValidator validator = new InsuranceValidator();

    private InsurancesModel insurancesModel;

    @FXML
    public void registerCabinInsurance() throws InvalidInsurancePropertiesException {
       errorLabel.setText("");

        System.out.print(insurancesModel.getCurrentPersonId().isEmpty());
        System.out.print(adress.getText());
        System.out.print(buildingMaterial.getValue().toString());
        System.out.print(cabinSize.getText());
        System.out.print(insurancePremiumBuilding.getText());
        System.out.print(insurancePremiumHousing.getText());
        System.out.print(buildingType.getValue().toString());
        if (buildingMaterial.getValue() == null || standard.getValue() == null || buildingType.getValue() == null) {
            throw new InvalidInsurancePropertiesException("Husk at alle feltene må fylles ut før registrering");
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
                        yearBuilt.getText(),
                        insurancePremiumBuilding.getText(),
                        insurancePremiumHousing.getText()
                        );

                insurancesModel.getAllInsurances().add(newCabinInsurance);
            } catch (InvalidInsurancePropertiesException ex) {
                errorLabel.setText(ex.getMessage());
            }
        }

        }
      //  errorLabel.setText(ex.getMessage());
    }
