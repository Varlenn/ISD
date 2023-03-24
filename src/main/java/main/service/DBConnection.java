package main.service;

import java.sql.*;
import java.util.Properties;

public class DBConnection {
    private Statement statement;
    private Connection connection;
    ResultSet rSet = null;

    public DBConnection() {
        System.out.println("Connecting to database ...\n");
        final String url = "jdbc:postgresql://172.20.8.18:5432/db0092_22";
        try {
            Class.forName("org.postgresql.Driver");

            final Properties properties = new Properties();
            properties.setProperty("user", "st0092");
            properties.setProperty("password", "qwerty92");
            properties.setProperty("charSet", "UTF-8");
            connection = DriverManager.getConnection(url, properties);
            statement = connection.createStatement();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void executeQuery(String query) throws SQLException {
        statement.executeUpdate(query);
    }

    public int getUpdateCount() throws SQLException {
        return statement.getUpdateCount();
    }

    public int getUpdatedRows() {
        try {
            return statement.getUpdateCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public ResultSet getRSet(String query) throws SQLException {
        statement = connection.createStatement();
        rSet = statement.executeQuery(query);

        return rSet;
    }
}
