package org.company.name.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private final static String URL = "jdbc:mysql://localhost:3306/library";
    private final static String PASS = "root";
    private final static String NAME = "root";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, NAME, PASS);
    }
}
