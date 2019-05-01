package com.mikkelgud;

//import SaveToFile.SaveStrategy;

import com.mikkelgud.person.InvalidPersonPropertiesException;
import com.mikkelgud.person.Person;
import com.mikkelgud.person.PersonListModel;
import com.mikkelgud.person.RegistratorController;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Controller implements Initializable {
    @FXML
    TextField customerSearchInput;
    @FXML
    public ListView personListView;
    @FXML
    public ListView currPersonListView;
    @FXML
    public ListView currPersonInsuranceListView;

    private static PersonListModel personListModel;

    // Using init-method to tell what will be printed to the GUI
    @FXML
    public void init(PersonListModel personListModel) {
        if (this.personListModel != null) {
            System.err.println("Wops! We shouldn't have more than one person list model!");
            System.exit(0);
        }
        this.personListModel = personListModel;
        initPersonListView(personListModel);
        initCurrentPersonView(personListModel.getCurrentPerson());
        initCurrentPersonInsuranceView(personListModel.getCurrentPerson());
        initSearchInputField();
    }

    //search input
    @FXML
    private void initSearchInputField() {
        customerSearchInput.selectedTextProperty().addListener((obs, oldValue, newValue) -> {
            System.out.println("hello" + oldValue + newValue);
            personListModel.setFilteredPersonList((personListModel.getPersonList().filtered(person -> !newValue.isEmpty() ||
                    !(person.getFirstName().toLowerCase().contains(newValue.toLowerCase()))
                    || person.getLastName().toLowerCase().contains(newValue.toLowerCase())
            )));
        });
    }
// getCustomerSearchInput().isEmpty()

//                                || !(person.getFirstName().toLowerCase().contains(getCustomerSearchInput().toLowerCase())
//                                || person.getLastName().toLowerCase().contains(getCustomerSearchInput().toLowerCase())))});
//        customerSearchInput.onInputMethodTextChangedProperty().addListener(e -> {
//            System.out.println("Search query: " + customerSearchInput.selectedTextProperty());


    @FXML
    private void initCurrentPersonInsuranceView(Person currentPerson) {
    }

    @FXML
    private void initCurrentPersonView(Person currentPerson) {
        currPersonListView.setItems(personListModel.getCurrentPersonListAttributes());

        currPersonListView.setCellFactory(lv -> new ListCell<>() {
            @Override
            public void updateItem(Object s, boolean empty) {
                super.updateItem(s, empty);

                StringProperty y = (StringProperty) s;

                if (empty) {
                    setText(null);
                } else {
                    setText(y.getValue());
                }
            }
        });
    }

    @FXML
    private void initPersonListView(PersonListModel personListModel) {
        personListView.setItems(personListModel.getPersonList());

        // Handle when user clicks a person (set clicked person to current person).
        personListView.getSelectionModel().selectedItemProperty().addListener(
                (observer, oldSelection, newSelection) -> personListModel.setCurrentPerson((Person) newSelection));

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
            public void updateItem(Object person, boolean empty) {
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
    private void initInsuranceView() {
        // Denne skal vise Personen som er klikket sine forsikringer.
    }


    @FXML
    private void newInsuranceUserWindowOpener() {
        URL resource = getClass().getClassLoader().getResource("registrering.fxml");
        FXMLLoader loader = new FXMLLoader(resource);
        try {
            Parent root = loader.load();
            RegistratorController controller = loader.getController();
            controller.setPersonModel(personListModel);
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
    public void newHouseInsurance() {
        URL resource = getClass().getClassLoader().getResource("housingInsurance.fxml");
        FXMLLoader loader = new FXMLLoader(resource);

        try {
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
    public void newBoatInsurance() {
        URL resource = getClass().getClassLoader().getResource("boatInsurance.fxml");
        FXMLLoader loader = new FXMLLoader(resource);

        try {
            Parent root = loader.load();
            loader.setController(this);

            Scene scene = new Scene(root);

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Registrer din båtforsikring");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    public void newCabinInsurance() {
        URL resource = getClass().getClassLoader().getResource("cabinInsurance.fxml");
        FXMLLoader loader = new FXMLLoader(resource);

        try {
            Parent root = loader.load();
            loader.setController(this);

            Scene scene = new Scene(root);

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Registrer din fritidsbolig");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    public void newTravelInsurance() {
        URL resource = getClass().getClassLoader().getResource("travelInsurance.fxml");
        FXMLLoader loader = new FXMLLoader(resource);

        try {
            Parent root = loader.load();
            loader.setController(this);

            Scene scene = new Scene(root);

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Registrer din reiseforsikring");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String getCustomerSearchInput() {
        return customerSearchInput.getText();
    }
    
    public void saveFile() {
        
    }
    
    public void openFile() throws IOException, InvalidPersonPropertiesException {
//        ReadStrategy readStrat = new ReadStrategy();
//        readStrat.read();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}


