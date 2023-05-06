package com.example.album;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class DisplayController {
    @FXML
    private TextArea display_area;
    private Stage stage;
    private Scene scene;
    private Parent root;
    public String Username;
    public DisplayController(){

    }
    public void setUsername(String u){
        Username = u;
    }
    public void switchToUI(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("UI.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void display() {
        String url = "jdbc:mysql://localhost:3306/myDB";
        String username = "root";
        String password = "jiayaojie0715";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, username, password);

            String sql = "SELECT SongName, Artist FROM users WHERE user_name = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(sql);
            preparedStmt.setString(1, Username);
            ResultSet pass = preparedStmt.executeQuery();

//            while(pass.next()){
//                display_area.appendText(resultSet.getString(1) + " " + resultSet.getString(2 )+ " " + resultSet.getString(3 )+  System.lineSeparator());
//            }

            connection.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }



}
