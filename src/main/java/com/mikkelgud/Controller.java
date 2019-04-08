package com.mikkelgud;

import com.mikkelgud.person.InvalidPersonPropertiesException;
import com.mikkelgud.person.Person;
import com.mikkelgud.person.PersonValidator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Controller {

    @FXML
    private Color x2;

    @FXML
    private Font x1;

    @FXML
    private Color x4;

    @FXML
    private Font x3;

    @FXML
    public AnchorPane kundeNavn;

    @FXML
    public TextField firstName;
    public TextField lastName;
    public TextField billingAddress;
    public Label errorLabel;

    @FXML
    public Button registrer;

    @FXML
    public ListView<Person> personListView;
    public static ObservableList<Person> personList = FXCollections.observableArrayList();


    private final PersonValidator validator = new PersonValidator();


    public void init() {
        personListView.setCellFactory(lv -> new ListCell<>() {
            @Override
            public void updateItem(Person person, boolean empty) {
                super.updateItem(person, empty);
                if (empty) {
                    setText(null);
                } else {
                    setText(person.getFirstName() + " " + person.getLastName());
                }
            }
        });

    }

    @FXML
    private void handleRegistrerButtonAction(ActionEvent event){
        errorLabel.setText("");
        try {
            Person newPerson = validator.createNew(firstName.getText(), lastName.getText(), billingAddress.getText());
            personList.add(newPerson);
            personListView.setItems(personList);
            resetFieldValues();
        } catch (InvalidPersonPropertiesException ex) {
            errorLabel.setText(ex.getMessage());
        }
    }

    private void resetFieldValues() {
        firstName.setText("");
        lastName.setText("");
        billingAddress.setText("");
    }

    @FXML
    public void onClickOpener(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("registrering.fxml"));

        try {
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Report Page");
            stage.setScene(new Scene(fxmlLoader.load()));
            stage.setResizable(false);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
