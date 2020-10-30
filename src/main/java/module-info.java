module at.weine {
    requires javafx.controls;
    requires javafx.fxml;

    opens at.weine to javafx.fxml;
    exports at.weine;
}