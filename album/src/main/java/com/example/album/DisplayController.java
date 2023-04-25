package com.example.album;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DisplayController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToUI(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("UI.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void display() {
        String url = "jdbc:mysql://localhost:3306/myDB";
        String username = "root";
        String password = "jiayaojie0715";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }


}
