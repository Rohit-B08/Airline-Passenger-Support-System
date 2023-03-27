package driver;
import database.initialDatabaseSetup;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

public class driver extends Application {
    public void start(Stage stage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("APSS/src/main/java/guis/loginScreen.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch(Exception e) {
            e.printStackTrace();
        }

//    public static void main(String[] args) throws SQLException {
//        Scanner scanner = new Scanner(System.in);
////            System.out.print("Please enter your password for mysql database : ");
//
////            String pass = scanner.next();
//            try {
//                initialDatabaseSetup connection = new initialDatabaseSetup("rohit@2002");
//                connection.initializeDatabase();
////                connection.resetDataBase();
//            }
//            catch (Exception e) {
//                e.printStackTrace();
//                System.out.println("Something wrong happened!");
//            }
//    }
}
