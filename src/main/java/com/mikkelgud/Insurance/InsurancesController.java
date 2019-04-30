package com.mikkelgud.Insurance;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class InsurancesController {
    @FXML
    public TextField boatType;
    public TextField length;
    public TextField model;
    public TextField engineType;
    public TextField enginePower;
    @FXML
    private Label errorLabel;

    private final InsuranceValidator validator = new InsuranceValidator();


    @FXML
    private void registrateBoatInsureanceButtonHandeler(ActionEvent e) {
        errorLabel.setText("");
        try {
            BoatInsurance newBoatInsurance =
                    validator.createNewBoatInsurance(boatType.getText(), length.getText(), model.getText(), engineType.getText(), enginePower.getText());
//            boatInsuranceList.add(newBoatInsurance);


            closeRegistrationButtonHandeler();
        } catch (InvalidInsurancePropertiesExcepetion ex) {
            errorLabel.setText(ex.getMessage());
        }

    }

    private void closeRegistrationButtonHandeler() {
        Stage stage = (Stage) Stage.getWindows();
        stage.close();
    }


}
