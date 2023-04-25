package com.example.album;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    public Connection con = null;
    final String URL = "jdbc:mysql://localhost:3306/myDB";
    final String USERNAME = "root";
    final String PASSWORD = "jiayaojie0715";

    public void add() {
        try {
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}
