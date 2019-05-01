package com.mikkelgud.person;

import com.mikkelgud.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class RegistratorController {

    Controller mainController = new Controller();

    @FXML
    public CheckBox insuranceHouse;
    @FXML
    public CheckBox insuranceTravel;
    @FXML
    public CheckBox insuranceBoat;
    @FXML
    public CheckBox insuranceCabin;
    @FXML
    public Button registrer;
    @FXML
    public AnchorPane kundeNavn;
    @FXML
    public TextField firstName;
    @FXML
    public TextField lastName;
    @FXML
    public TextField billingAddress;
    @FXML
    private Label errorLabel;


    @FXML
    public Button closeRegistrationPageButton;

    private PersonListModel personListModel;

    private final PersonValidator validator = new PersonValidator();


    @FXML
    private void handleRegistrerButtonAction(ActionEvent event) {
        errorLabel.setText("");
        try {
            Person newPerson = validator.createNewPerson(firstName.getText(), lastName.getText(), billingAddress.getText());
            newPerson.setInsuranceBoat(insuranceBoat.isSelected());
            newPerson.setInsuranceCabin(insuranceCabin.isSelected());
            newPerson.setInsuranceHouse(insuranceHouse.isSelected());
            newPerson.setInsuranceTravel(insuranceTravel.isSelected());
            personListModel.getPersonList().add(newPerson);

            openCheckedOutInsurances();
            resetFieldValues();
        } catch (InvalidPersonPropertiesException ex) {
            errorLabel.setText(ex.getMessage());
        }
    }

    private void openCheckedOutInsurances() {
        if (insuranceBoat.isSelected()) {
            mainController.newBoatInsurance();
        }
        if (insuranceCabin.isSelected()) {
            mainController.newCabinInsurance();
        }
        if (insuranceHouse.isSelected()) {
            mainController.newHouseInsurance();
        }
        if (insuranceTravel.isSelected()) {
            mainController.newTravelInsurance();
        }
    }

    private void resetFieldValues() {
        firstName.setText("");
        lastName.setText("");
        billingAddress.setText("");
        insuranceBoat.setSelected(false);
        insuranceCabin.setSelected(false);
        insuranceHouse.setSelected(false);
        insuranceTravel.setSelected(false);
    }

    @FXML
    public void closeRegistrationButtonHandeler(ActionEvent event) {
        Stage stage = (Stage) closeRegistrationPageButton.getScene().getWindow();

        stage.close();
    }


    public void setPersonModel(PersonListModel personListModel) {
        this.personListModel = personListModel;
    }
}
