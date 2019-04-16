package com.mikkelgud;

import com.mikkelgud.person.InvalidPersonPropertiesException;
import com.mikkelgud.person.Person;
import com.mikkelgud.person.PersonListModel;
import com.mikkelgud.person.PersonValidator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Controller implements Initializable {

    @FXML private Color x2;

    @FXML private Font x1;

    @FXML private Color x4;

    @FXML private Font x3;

    @FXML public AnchorPane kundeNavn;
    @FXML public TextField firstName;
    @FXML public TextField lastName;
    @FXML public TextField billingAddress;
    @FXML public Label errorLabel;
    @FXML public CheckBox insuranceHouse;
    @FXML public CheckBox insuranceTravel;
    @FXML public CheckBox insuranceBoat;
    @FXML public CheckBox insuranceCabin;
    @FXML public Button registrer;
    @FXML
    public Button closeRegistrationPageButton;
    @FXML public ListView<Person> personListView;


    private final PersonValidator validator = new PersonValidator();
    private static PersonListModel personListModel;


    public void init(PersonListModel personListModel) {

        if (this.personListModel != null) {
            System.err.println("Wops! We shouldn't have more than one person list model!");
            System.exit(0);
        }

        this.personListModel = personListModel;

        personListView.setItems(personListModel.getPersonList());

        // Handle when user clicks a person (set clicked person to current person).
        personListView.getSelectionModel().selectedItemProperty()
                .addListener((observer, oldSelection, newSelection) ->
                        personListModel.setCurrentPerson(newSelection));

        // Handle when new person is clicked (after another one has been selected).
        personListModel.currentPersonProperty().addListener((obs, oldPerson, newPerson) -> {
            if (newPerson == null) {
                personListView.getSelectionModel().clearSelection();
            } else {
                personListView.getSelectionModel().select(newPerson);
            }
        });

        personListView.setCellFactory(lv -> new ListCell<>() {
            @Override
            public void updateItem(Person person, boolean empty) {
                super.updateItem(person, empty);
                if (empty) {
                    setText(null);
                } else {
                    setText(person.toString());
                }
            }
        });

    }

    @FXML
    private void handleRegistrerButtonAction(ActionEvent event){
        errorLabel.setText("");
        try {
            Person newPerson = validator.createNew(firstName.getText(), lastName.getText(), billingAddress.getText());
            newPerson.setInsuranceBoat(insuranceBoat.isSelected());
            newPerson.setInsuranceCabin(insuranceCabin.isSelected());
            newPerson.setInsuranceHouse(insuranceHouse.isSelected());
            newPerson.setInsuranceTravel(insuranceTravel.isSelected());
            personListModel.getPersonList().add(newPerson);

            resetFieldValues();
        } catch (InvalidPersonPropertiesException ex) {
            errorLabel.setText(ex.getMessage());
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
    public void onClickOpener(){
        URL resource = getClass().getClassLoader().getResource("registrering.fxml");
        FXMLLoader loader = new FXMLLoader(resource);

        try {
            Parent root = loader.load();
            loader.setController(this);

            Scene scene = new Scene(root);

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Registrering");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void newInsurance(){
        URL resource = getClass().getClassLoader().getResource("housingInsuranceGUI.fxml");
        FXMLLoader loader = new FXMLLoader(resource);
        
        try{
            Parent root = loader.load();
            loader.setController(this);
            
            Scene scene = new Scene(root);
            
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Registrer din husholdningsforsikring");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    public void closeButtonHandeler(ActionEvent event) {
        Stage stage = (Stage) closeRegistrationPageButton.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
