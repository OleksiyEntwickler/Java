package com.example.project;

import javafx.fxml.FXML;

import java.sql.Connection;
import java.sql.DriverManager;

public class Datenbank {
    @FXML
    public Connection conn;
    @FXML
    public Connection getDBC() {
        String url = "jdbc:sqlite:Buch3";
        try {
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
