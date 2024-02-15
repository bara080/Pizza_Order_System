module com.example.eventhandler {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;



    opens com.example.eventhandler to javafx.fxml;
    exports com.example.eventhandler;
}