module com.mikkelgud {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;

    opens com.mikkelgud to javafx.fxml;
    opens com.mikkelgud.person to javafx.fxml;
    opens com.mikkelgud.insurance to javafx.fxml;
    exports com.mikkelgud;
}