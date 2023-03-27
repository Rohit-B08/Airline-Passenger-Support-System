package driver;
import database.initialDatabaseSetup;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

public class driver {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
//            System.out.print("Please enter your password for mysql database : ");

//            String pass = scanner.next();
            try {
                initialDatabaseSetup connection = new initialDatabaseSetup("rohit@2002");
                connection.initializeDatabase();
//                connection.resetDataBase();
            }
            catch (Exception e) {
                e.printStackTrace();
                System.out.println("Something wrong happened!");
            }
    }
}
