package com.mikkelgud.insurance;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

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

    private final String insuranceYearlyPayment = "1000";
    private final String insuranceAmount = "300 000";
    private final String insuranceCoverage = "Dekker all skade i forbindelse med din båt på vannet eller under henholdsmessig frakt.";

    private final InsuranceValidator validator = new InsuranceValidator();

    private InsurancesModel insurancesModel;

    public void registrateTravelInsurance(ActionEvent event){
        try{
            TravelInsurance newTravelInsurance = validator.createNewTravelInsurance(insuranceYearlyPayment,
                    insuranceAmount,
                    insuranceCoverage,
                    southAmerica.isSelected(),
                    northAmerica.isSelected(),
                    asia.isSelected(),
                    oseania.isSelected(),
                    africa.isSelected(),
                    europe.isSelected()
                    );
            insurancesModel.getAllInsurances().add(newTravelInsurance);
        } catch (InvalidInsurancePropertiesException e) {
            e.printStackTrace();
        }
    }

    public void setInsurancesModel(InsurancesModel insurancesModel) {
        this.insurancesModel = insurancesModel;
    }

  //  public void getPrintImportantInformation() {
    //    insuranceYearlyPaymentOutPrint.setText(insuranceYearlyPayment);
      //  insuranceAmountOutPrint.setText(insuranceAmount);
    //    InsuranceCoverageInfoOutPrint.setText(insuranceCoverage);
    //}

}
