package guis;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.geometry.*;
import javafx.event.ActionEvent;

public class loginScreen extends Application {
    private Text titleTxt;

    private TextField usernameField;
    private TextField passwordField;

    private Button loginButton;

    public void start(Stage primaryStage) {
        primaryStage.setTitle("APSS");

        titleTxt = new Text("Airline Passenger Support System");
        titleTxt.setFont(Font.font("Arial", 20));

        usernameField = new TextField();
        usernameField.setPromptText("username");
        usernameField.setPrefWidth(110);
        passwordField = new TextField();
        passwordField.setPromptText("password");
        passwordField.setPrefWidth(110);

        loginButton = new Button("Login");
        loginButton.setFont(Font.font("arial", 14));
        loginButton.setOnAction(this::eventHandler);

        GridPane mainPane = new GridPane();
        mainPane.setAlignment(Pos.CENTER);

        GridPane.setHalignment(titleTxt, HPos.CENTER);
        GridPane.setHalignment(usernameField, HPos.CENTER);
        GridPane.setHalignment(passwordField, HPos.CENTER);
        GridPane.setHalignment(loginButton, HPos.CENTER);

        mainPane.add(titleTxt, 0, 0, 1, 1);
        mainPane.add(usernameField, 0, 2, 1, 1);
        mainPane.add(passwordField, 0, 3, 1, 1);
        mainPane.add(loginButton, 0, 4, 1, 1);

        mainPane.setHgap(12);
        mainPane.setVgap(12);



        Scene scene = new Scene(mainPane, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void eventHandler(ActionEvent event) {
    }
}
