module com.example.album {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.album to javafx.fxml;
    exports com.example.album;
}