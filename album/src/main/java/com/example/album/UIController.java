package com.example.album;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.*;

public class UIController {
    @FXML
    private TextField song_field;
    @FXML
    private TextField artistis_field;
    @FXML
    private TextField length_field;


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


}
