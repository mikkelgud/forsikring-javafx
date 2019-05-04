package com.mikkelgud.claimForm;

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

    ClaimInsuranceValidator validator = new ClaimInsuranceValidator();
    private ClaimInusranceModel claimInusranceModel;

    @FXML
    private void registerClaimedInsurance(ActionEvent event) {
        errorLabel.setText("");
        try {
            ClaimInsurance newClaimedInsurance = validator.createNewClaimInsurance(claimInusranceModel.getCurrentPersonId(), typeOfDamage.getText(), dateOfDamage.getValue().toString(), descriptionOfDamage.getText(), taxationValue.getText(), witnesses.getText(), moneyBack.getText());
            claimInusranceModel.getAllClaimedInsurances().addAll(newClaimedInsurance);
            closePage();

        } catch (InvalidClaimRegistrationException ex) {
            errorLabel.setText(ex.getMessage());
        }
    }

    private void closePage() {
        Stage stage = (Stage) registerClaimedInsurance.getScene().getWindow();
        stage.close();
    }


    public void setClaimedInsurancesModel(ClaimInusranceModel claimInusranceModel) {
        this.claimInusranceModel = claimInusranceModel;
    }

}
