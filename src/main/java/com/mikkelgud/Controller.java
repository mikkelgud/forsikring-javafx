package com.mikkelgud;

import com.mikkelgud.person.InvalidPersonPropertiesException;
import com.mikkelgud.person.Person;
import com.mikkelgud.person.PersonValidator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
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
    public TextField fornavn;
    public TextField etternavn;
    public TextField fakturaadresse;
    public Label errorLabel;

    @FXML
    public Button registrer;
    private String firstName;
    private String lastName;
    private String billingAdress;

    private List<Person> personList;
    private Person newPerson;

    private final PersonValidator validator = new PersonValidator();

    @FXML
    private void handleRegistrerButtonAction(ActionEvent event){
        try {
            Person person = validator.createNew(firstName, lastName, billingAdress);
        } catch (InvalidPersonPropertiesException ex) {
            errorLabel.setText(ex.getMessage());
        }
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
