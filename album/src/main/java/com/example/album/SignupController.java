package com.example.album;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class SignupController {
    @FXML
    private TextField signupusername;
    @FXML
    private TextField signuppassword;

    private Stage stage;
    private Scene scene;
    private Parent root;
    public void switchToLogin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void clickToSignup(){
        String url = "jdbc:mysql://localhost:3306/myDB";
        String username = "root";
        String password = "jiayaojie0715";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");


            Connection connection = DriverManager.getConnection(url, username, password);


            String sql = " insert into users (id, user_name, password)"
                    + " values (?, ?, ?)";
            PreparedStatement preparedStmt = connection.prepareStatement(sql);
            preparedStmt.setInt (1, (int)((Math.random()*(100-0))+0));

            preparedStmt.setString (2, signupusername.getText());
            preparedStmt.setString   (3, signuppassword.getText());
            preparedStmt.execute();



            connection.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
