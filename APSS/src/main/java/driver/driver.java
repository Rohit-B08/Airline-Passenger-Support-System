package driver;
import database.initialDatabaseSetup;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class driver extends Application {
    public void start(Stage stage) {
        try {
            initialDatabaseSetup connection = new initialDatabaseSetup("rohit@2002"); //Enter your mysql pass
//            connection.initializeDatabase();
//            connection.resetDataBase();
            Parent root = FXMLLoader.load(getClass().getResource("loginScreen.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) throws SQLException {
//        Scanner scanner = new Scanner(System.in);
//            System.out.print("Please enter your password for mysql database : ");
//
//            String pass = scanner.next();
//            try {
//                initialDatabaseSetup connection = new initialDatabaseSetup("rohit@2002");
//                connection.initializeDatabase();
//                connection.resetDataBase();
//                ResultSet result = connection.passengerTable();
//                while (result.next()) {
//                    System.out.print(result.getString(2) + "\t");
//                    System.out.println(result.getString(3));
//                }
//            }
//            catch (Exception e) {
//                e.printStackTrace();
//                System.out.println("Something wrong happened!");
//            }
//    }
}
