package com.example.TrivialApp;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {

    public Connection databaseLink;
    static String  databaseName = "quizdatabase";
    static String databaseUser = "root";
    static String databasePassword = "";
    static String url = "jdbc:mysql://localhost/" + databaseName;
    static String driver = "com.mysql.jdbc.Driver";

    public static Connection getConnection() {

        Connection con = null;

        try {
            Class.forName(driver);
            try {
                con = DriverManager.getConnection(url, databaseUser, databasePassword);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException();
        }
        return con;
    }

}

