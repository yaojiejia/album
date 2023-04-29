package com.example.album;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;



public class UIController {
    @FXML
    private TextField song_field;
    @FXML
    private TextField artistis_field;
    @FXML
    private TextField length_field;

    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    protected void addSong() {
        String url = "jdbc:mysql://localhost:3306/myDB";
        String username = "root";
        String password = "jiayaojie0715";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");


            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            String sql = " insert into Song (SongName, Artist, LengthSeconds)"
                    + " values (?, ?, ?)";
            PreparedStatement preparedStmt = connection.prepareStatement(sql);
            preparedStmt.setString (1, song_field.getText());
            preparedStmt.setString (2, artistis_field.getText());
            preparedStmt.setString   (3, length_field.getText());
            preparedStmt.execute();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM Song");
            while(resultSet.next()){
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2 )+ " " + resultSet.getString(3 )+ " " +resultSet.getString(4 )+ " " +resultSet.getString(5 )+ " " );
            }

            connection.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }


    public void switchToDisplay(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("display.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



}
