package com.mikkelgud.claimForm;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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

}
