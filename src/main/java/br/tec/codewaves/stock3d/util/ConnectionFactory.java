package br.tec.codewaves.stock3d.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class ConnectionFactory {
    public static final String DRIVER = "org.postgresql.Driver";
    public static final String URL = System.getenv("DB_URL");

    public static final String USER = System.getenv("DB_USER");

    public static final String PASS =  System.getenv("DB_PASSWORD");


    //public static java.sql.Connection getConnection() {
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception ex) {
            throw new RuntimeException("Erro na conexão com o banco de dados", ex);
        }
    }

    public static void closeConnection(Connection connection) {

        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao fechar a conexão com o banco de dados", ex);
        }
    }

    public static void closeConnection(Connection connection, PreparedStatement statement) {
        closeConnection(connection);
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao fechar a conexão com o banco de dados", ex);
        }

    }
}
