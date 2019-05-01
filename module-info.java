module com.mikkelgud {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;

    opens com.mikkelgud to javafx.fxml;
    exports com.mikkelgud;
}