package Databases;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final Dotenv dotenv = Dotenv.configure().load();

    private static final String URL = dotenv.get("DATABASE_URL");
    private static final String USER = dotenv.get("DATABASE_USER");
    private static final String PASSWORD = dotenv.get("DATABASE_PASSWORD");

    public static Connection getConnection() throws SQLException {

        if(URL == null || USER == null || PASSWORD == null){
            throw new SQLException("Database credentials are missing or incorrect in the environment variables.");
        }

        return  DriverManager.getConnection(URL, USER, PASSWORD );
    }
}
