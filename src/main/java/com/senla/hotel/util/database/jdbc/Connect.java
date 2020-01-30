package com.senla.hotel.util.database.jdbc;

import com.senla.hotel.util.dependency.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class Connect implements IConnect {
    //  Database credentials
    private static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/hotel";
    private static final String USER = "postgres";
    private static final String PASS = "postgres";
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void execute() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        connection = null;

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
