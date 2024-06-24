module com.example.easyquiz {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.TrivialApp to javafx.fxml;
    exports com.example.TrivialApp;
}