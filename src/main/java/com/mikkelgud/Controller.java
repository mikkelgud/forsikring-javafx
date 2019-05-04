package com.mikkelgud;

//import com.mikkelgud.filehandling.SaveStrategy;

import com.mikkelgud.claimForm.ClaimInsuranceRegistrationController;
import com.mikkelgud.claimForm.ClaimInusranceModel;
import com.mikkelgud.filehandling.ReadStrategy;
import com.mikkelgud.insurance.*;
import com.mikkelgud.person.InvalidPersonPropertiesException;
import com.mikkelgud.person.Person;
import com.mikkelgud.person.PersonListModel;
import com.mikkelgud.person.RegisterPersonController;
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
    @FXML
    public ListView currPersonClaimedInsurancesListVeiw;

    private static PersonListModel personListModel;
    private static InsurancesModel insurancesModel;
    private static ClaimInusranceModel claimInusranceModel;

    // Using init-method to tell what will be printed to the GUI
    @FXML
    public void init(PersonListModel personListModel, InsurancesModel insurancesModel, ClaimInusranceModel claimInusranceModel) {
        if (Controller.personListModel != null) {
            System.err.println("Wops! We shouldn't have more than one person list model!");
            System.exit(0);
        }
        Controller.personListModel = personListModel;
        Controller.insurancesModel = insurancesModel;
        Controller.claimInusranceModel = claimInusranceModel;

        initPersonListView();
        initCurrentPersonView(personListModel.getCurrentPerson());
        initCurrentPersonInsuranceView();
        initCurrentPersonClaimInsuranceView();
        //initSearchInputField();
    }

    //search input coming soon
//    @FXML
//    private void initSearchInputField() {
//        customerSearchInput.selectedTextProperty().addListener((obs, oldValue, newValue) -> {
//            System.out.println("hello" + oldValue + newValue);
//            personListModel.setFilteredPersonList((personListModel.getPersonList().filtered(person -> !newValue.isEmpty() ||
//                    !(person.getFirstName().toLowerCase().contains(newValue.toLowerCase()))
//                    || person.getLastName().toLowerCase().contains(newValue.toLowerCase())
//            )));
//        });
//    }
// getCustomerSearchInput().isEmpty()

//                                || !(person.getFirstName().toLowerCase().contains(getCustomerSearchInput().toLowerCase())
//                                || person.getLastName().toLowerCase().contains(getCustomerSearchInput().toLowerCase())))});
//        customerSearchInput.onInputMethodTextChangedProperty().addListener(e -> {
//            System.out.println("Search query: " + customerSearchInput.selectedTextProperty());

    @FXML
    private void initCurrentPersonClaimInsuranceView() {
        currPersonClaimedInsurancesListVeiw.setItems(claimInusranceModel.getCurrentPersonsInsurances());

        currPersonInsuranceListView.setCellFactory(lv -> new ListCell<>() {
            @Override
            public void updateItem(Object s, boolean empty) {

                if (s != null) {
                    super.updateItem(s, empty);
                    StringProperty y = (StringProperty) s;

                    if (empty) {
                        setText(null);
                    } else {
                        setText(y.getValue());
                    }
                } else {
                    super.updateItem(null, true);
                    setText("");
                }
            }
        });
    }

    @FXML
    private void initCurrentPersonInsuranceView() {
        currPersonInsuranceListView.setItems(insurancesModel.getCurrentPersonsInsurances());

        currPersonInsuranceListView.setCellFactory(lv -> new ListCell<>() {
            @Override
            public void updateItem(Object s, boolean empty) {

                if (s != null) {
                    super.updateItem(s, empty);
                    StringProperty y = (StringProperty) s;

                    if (empty) {
                        setText(null);
                    } else {
                        setText(y.getValue());
                    }
                } else {
                    super.updateItem(null, true);
                    setText("");
                }
            }
        });
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
    private void initPersonListView() {
        personListView.setItems(personListModel.getPersonList());

        // Handle when user clicks a person (set clicked person to current person).
        personListView.getSelectionModel().selectedItemProperty().addListener(
                (observer, oldSelection, newSelection) -> {
                    personListModel.setCurrentPerson((Person) newSelection);
                    insurancesModel.setCurrentPersonId(((Person) newSelection).getPersonId());
                    insurancesModel.setCurrentPersonsInsurances();
                    claimInusranceModel.setCurrentPersonId(((Person) newSelection).getPersonId());
                    claimInusranceModel.setCurrentPersonsInsurances();
                }
        );

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
        URL resource = getClass().getClassLoader().getResource("personRegistration.fxml");
        FXMLLoader loader = new FXMLLoader(resource);

        try {
            Parent root = loader.load();
            RegisterPersonController controller = loader.getController();
            controller.setPersonModel(personListModel);
            controller.setMainController(this);
            controller.setInsurancesModel(insurancesModel);
            openWindow(root, "Registrering");

        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void openWindow(Parent root, String registrering) {
        Scene scene = new Scene(root);

        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(registrering);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    public void newHouseInsurance() {
        URL resource = getClass().getClassLoader().getResource("housingInsurance.fxml");
        FXMLLoader loader = new FXMLLoader(resource);

        try {
            Parent root = loader.load();
            HouseInsuranceController insurancesController = loader.getController();
            insurancesController.setInsurancesModel(insurancesModel);
            openWindow(root, "Registrer din husholdningsforsikring");
            insurancesController.getPrintImportantInformation();
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
            BoatInsurancesController insurancesController = loader.getController();
            insurancesController.setInsurancesModel(insurancesModel);
            openWindow(root, "Registrer din båtforsikring");
            insurancesController.getPrintImportantInformation();
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
            CabinInsuranceController insuranceController = loader.getController();
            insuranceController.setInsurancesModel(insurancesModel);
            openWindow(root, "Registrer din fritidsbolig");
            insuranceController.getPrintImportantInformation();
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
            TravelInsuranceController insuranceController = loader.getController();
            insuranceController.setInsurancesModel(insurancesModel);
            openWindow(root, "Registrer din reiseforsikring");
            insuranceController.getPrintImportantInformation();
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void openClaimInsurance() {
        URL resource = getClass().getClassLoader().getResource("claimInsuranceRegistration.fxml");
        FXMLLoader loader = new FXMLLoader(resource);

        try {
            Parent root = loader.load();
            ClaimInsuranceRegistrationController claimInsuranceRegistrationController = loader.getController();
            claimInsuranceRegistrationController.setClaimedInsurancesModel(claimInusranceModel);
            openWindow(root, "Registrer din skademelding");
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String getCustomerSearchInput() {
        return customerSearchInput.getText();
    }
    
    public void saveFile() {
        
    }

    public void openFile() throws InvalidPersonPropertiesException {
        ReadStrategy readStrat = new ReadStrategy();
        readStrat.readFile();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}


