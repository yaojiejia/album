package com.example.album;

public class DataConnection {
    public static final DataConnection instance = new DataConnection();
    private String username;
    private DataConnection(){}
    public static DataConnection getInstance(){
        return instance;
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String u){
        username = u;
    }
}
