module com.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;
    requires javafx.swing;

    opens com.example.Controller to javafx.fxml;
    exports com.example;
}
