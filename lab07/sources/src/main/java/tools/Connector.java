package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connector {
    public static Connection connection;
    public static Statement statement;
    public Connector() throws SQLException {
        connect();
        statement = Connector.connection.createStatement();
    }
    public static void connect() {
        try {
            // db parameters
            String url = "jdbc:sqlite:C:/Users/Krzysztof/Desktop/SQLite/mydatabase.db";
            // create a connection to the database
            connection = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}