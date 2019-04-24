package com.mikkelgud;

import SaveToFile.SaveStrategy;
import com.mikkelgud.person.Person;
import com.mikkelgud.person.PersonListModel;
import com.mikkelgud.person.RegistreringController;
import java.io.File;
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
import readFromFile.ReadFromFile;
import readFromFile.ReadStrategy;


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

    private void initSearchInputField() {
        customerSearchInput.onInputMethodTextChangedProperty().addListener(e -> {
            System.out.println("Search query: " + getCustomerSearchInput());
            personListModel.setFilteredPersonList(
                    personListModel.getPersonList().filtered(
                            person -> getCustomerSearchInput().isEmpty()
                                    || !(person.getFirstName().toLowerCase().contains(getCustomerSearchInput().toLowerCase())
                                    || person.getLastName().toLowerCase().contains(getCustomerSearchInput().toLowerCase())))
            );
        });
    }

    private void initCurrentPersonInsuranceView(Person currentPerson) {
    }

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

    private void initPersonListView(PersonListModel personListModel) {
        personListView.setItems(personListModel.getPersonList());

        // Handle when user clicks a person (set clicked person to current person).
        personListView.getSelectionModel().selectedItemProperty()
                .addListener((observer, oldSelection, newSelection) ->
                        personListModel.setCurrentPerson((Person) newSelection));

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
    public void newInsuranceUserWindowOpener() {
        URL resource = getClass().getClassLoader().getResource("registrering.fxml");
        FXMLLoader loader = new FXMLLoader(resource);

        try {
            Parent root = loader.load();
            RegistreringController controller = loader.getController();
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
    private void newHouseInsurance() {
        URL resource = getClass().getClassLoader().getResource("housingInsurance.fxml");
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
    private void newBoatInsurance() {
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
    private void newCabinInsurance() {
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
    private void newTravelInsurance() {
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
    
    public void openFile() throws IOException {
        ReadStrategy readStrat = new ReadStrategy();
        readStrat.read();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}
