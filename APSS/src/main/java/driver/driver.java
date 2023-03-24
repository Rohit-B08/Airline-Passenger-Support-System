package driver;
import database.initialDatabaseSetup;

import java.sql.SQLException;
import java.util.Scanner;

public class driver {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
            System.out.print("Please enter your password for mysql database : ");

            String pass = scanner.next();
            try {
                initialDatabaseSetup connection = new initialDatabaseSetup(pass);
                connection.initializeDatabase();
//                connection.resetDataBase();
            }
            catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Something wrong happened!");
            }
    }
}
