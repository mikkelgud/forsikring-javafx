package com.mikkelgud;

import com.mikkelgud.claimForm.ClaimInusranceModel;
import com.mikkelgud.insurance.InsurancesModel;
import com.mikkelgud.person.PersonListModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;


public class Main extends Application {

    PersonListModel personListModel = new PersonListModel();
    InsurancesModel insurancesModel = new InsurancesModel();
    ClaimInusranceModel claimInusranceModel = new ClaimInusranceModel();

    @Override
    public void start(Stage stage) throws Exception {
        URL resource = getClass().getClassLoader().getResource("main.fxml");
        FXMLLoader loader = new FXMLLoader(resource);
        Parent root = loader.load();
        Controller controller = loader.getController();
        controller.init(personListModel, insurancesModel, claimInusranceModel);
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
}
