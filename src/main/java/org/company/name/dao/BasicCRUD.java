package org.company.name.dao;

import org.apache.log4j.Logger;

import java.sql.*;

public class BasicCRUD {

    protected Connection connect;
    protected Statement statement;
    protected PreparedStatement preparedStatement;
    protected ResultSet resultSet;
    protected static Logger logger = Logger.getLogger(org.company.name.controller.MainServlet.class);
    Connection cn;


    public void closeConnection() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connect != null) {
                connect.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (SQLException e) {
            logger.error("Sql exception thrown;" + e);
        }
    }

    public Connection makeConnection() {
        DbConnection dbConnection = new DbConnection();
        try {
            cn = dbConnection.getConnection();
        } catch (SQLException e) {
            logger.error("Sql exception thrown;" + e);
        }
        return cn;
    }

}

