package com.example.album;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.example.album.DisplayController;
import javax.xml.transform.Result;
import java.io.IOException;
import java.sql.*;

public class LoginController {
    @FXML
    private TextField loginusername;
    @FXML
    private TextField loginpassword;
    @FXML
    private Label loginstatus;
    DataConnection data = DataConnection.getInstance();
    private Stage stage;
    private Scene scene;
    private Parent root;
    public void switchtoSignup(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("signup.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void login(ActionEvent event) throws IOException{
        String url = "jdbc:mysql://localhost:3306/myDB";
        String username = "root";
        String password = "jiayaojie0715";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");


            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();


            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
            String verified = " ";
            while(resultSet.next()){
                if(resultSet.getString(2 ).equals(loginusername.getText())){
                    verified = loginusername.getText();
                }
            }
            if(verified.equals(loginusername.getText())) {
                String sql = "SELECT password FROM users WHERE user_name = ?";
                PreparedStatement preparedStmt = connection.prepareStatement(sql);
                preparedStmt.setString(1, loginusername.getText());
                ResultSet pass = preparedStmt.executeQuery();

                while(pass.next()){
                    String temp = pass.getString(1);
                    if(temp.equals(loginpassword.getText())){
                        data.setUsername(loginusername.getText());
                        loginstatus.setText("success!");
                        Parent root = FXMLLoader.load(getClass().getResource("UI.fxml"));
                        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();


                    }
                    else{
                        loginstatus.setText("Wrong Credentials!");
                    }
                }


            }
            connection.close();
        }
        catch(Exception e){
            System.out.println(e);
        }

    }




}
