package database;
import java.sql.*;


public class initialDatabaseSetup {
    static String url = "jdbc:mysql://localhost/";
    static final String user = "root";
    static final String pass = "chAtEAUx45671234!";
    public static void main(String args[]) throws SQLException {
        Connection connection;
        try{
            connection = DriverManager.getConnection(url, user, pass);
            Statement stm = connection.createStatement();
            String showDatabase = "show databases";
            PreparedStatement preparedStatement = connection.prepareStatement(showDatabase);
            ResultSet result = preparedStatement.executeQuery();
            boolean exist = false;
            while(result.next()) {
                if(result.getString(1).equals("APSS")) {
                    exist = true;
                }
            }
            System.out.println(exist);
            if(!exist) {
                String createDb = "create database APSS";
                stm.executeUpdate(createDb);
                preparedStatement.executeQuery();
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }

}
