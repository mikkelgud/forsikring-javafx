package com.mikkelgud.claim;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class ClaimInsuranceRegistrationController {
    @FXML
    protected DatePicker dateOfDamage;
    @FXML
    protected TextField typeOfDamage;
    @FXML
    protected TextArea descriptionOfDamage;
    @FXML
    protected TextField taxationValue;
    @FXML
    protected TextArea witnesses;
    @FXML
    protected Label moneyBack;
    @FXML
    protected Label errorLabel;
    @FXML
    protected Button registerClaimedInsurance;

    private final ClaimInsuranceValidator validator = new ClaimInsuranceValidator();
    private ClaimInsuranceModel claimInsuranceModel;


    @FXML
    private void registerClaimedInsurance(ActionEvent event) {
        errorLabel.setText("");

        if (claimInsuranceModel.getCurrentPersonId() == null || claimInsuranceModel.getCurrentPersonId().equals("")) {
            errorLabel.setText("Wops! Du må velge en person i listen for å registrere en skade.");
        }

        try {
            int newInsuranceId = claimInsuranceModel.getAllClaimedInsurances().filtered(insurance -> insurance.getPersonId().equals(claimInsuranceModel.getCurrentPersonId())).size() + 1;
            ClaimInsurance newClaimedInsurance = validator.createNewClaimInsurance(newInsuranceId, claimInsuranceModel.getCurrentPersonId(), typeOfDamage.getText(), dateOfDamage.getValue().toString(), descriptionOfDamage.getText(), taxationValue.getText(), witnesses.getText(), moneyBack.getText());
            claimInsuranceModel.getAllClaimedInsurances().addAll(newClaimedInsurance);
            closePage();

        } catch (InvalidClaimRegistrationException ex) {
            errorLabel.setText(ex.getMessage());
        }
    }

    public void testAmount() {
        //Ettersom utregningen er såpass banal, gjør jeg den bare på enkeltvis her.
        int calculatedMoneyBack = (int) Math.floor(Integer.parseInt(taxationValue.getText()) * 0.991);
        moneyBack.setText(Integer.toString(calculatedMoneyBack) + "  Kroner");
    }

    private void closePage() {
        Stage stage = (Stage) registerClaimedInsurance.getScene().getWindow();
        stage.close();
    }


    public void setClaimedInsurancesModel(ClaimInsuranceModel claimInsuranceModel) {
        this.claimInsuranceModel = claimInsuranceModel;
    }

}
