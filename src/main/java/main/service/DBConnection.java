package main.service;
import java.sql.*;


public class DBConnection {
    private Statement statement;
    private Connection connection;
    ResultSet rSet = null;

    // создание подключения
    public DBConnection() {
        System.out.println("Connecting to database ...\n");
        final String url = "jdbc:postgresql://172.20.8.18:5432/db0092_22";
        try {
            Class.forName("org.postgresql.Driver");

            connection = DriverManager.getConnection(url, "st0092", "qwerty92");
            statement = connection.createStatement();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // функция, возвращающая подключение
    public Connection getConnection() {
        return connection;
    }

    // функция, исполняющая пришедший запрос
    public void executeQuery(String query) throws SQLException {
        statement.executeUpdate(query);
    }

    // функция, возвращающая количество обновленных строк
    public int getUpdateCount() throws SQLException {
        return statement.getUpdateCount();
    }

    // функция, возвращающая набор результатов по запросу
    public ResultSet getRSet(String query) throws SQLException {
        statement = connection.createStatement();
        rSet = statement.executeQuery(query);

        return rSet;
    }
}
