module com.example.easyquiz {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.TrivialApp to javafx.fxml;
    exports com.example.TrivialApp;
}