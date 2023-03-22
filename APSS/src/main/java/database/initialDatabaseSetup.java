package database;
import java.sql.*;
import java.util.Scanner;


public class initialDatabaseSetup {
    private final String url = "jdbc:mysql://localhost/";
    private final String user = "root";
    private String pass;

    public initialDatabaseSetup(String pass) throws SQLException {
        this.pass = pass;
    }

    public void setConnection() {
        Connection connection;
        try{
            connection = DriverManager.getConnection(url, user, pass);
            Statement stm = connection.createStatement();
            String showDatabase = "show databases";
            PreparedStatement preparedStatement = connection.prepareStatement(showDatabase);
            ResultSet result = preparedStatement.executeQuery();
            boolean exist = false;
            while(result.next()) {
                if((result.getString(1).toUpperCase()).equals("APSS")) {
                    exist = true;
                }
            }
            if(!exist) {
                String createDb = "create database APSS";
                stm.executeUpdate(createDb);
                preparedStatement.executeQuery();
            }
            System.out.println("Connected to database successfully!");
        }
        catch(SQLException e) {
            System.out.println("Connection failed!");
        }
    }

}
