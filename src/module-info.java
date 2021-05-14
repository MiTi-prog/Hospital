module Hospital {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;

    requires java.sql;
    requires mysql.connector.java;

// to gor je namest tega
//--module-path D:\Library\JavaFX\javafx-sdk-16\lib --add-modules javafx.controls,javafx.fxml,javafx.web

    opens sample;
}