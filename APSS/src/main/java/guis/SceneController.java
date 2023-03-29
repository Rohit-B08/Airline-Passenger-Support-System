package guis;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class SceneController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    //    public void switchToLoginScreen(ActionEvent event) throws IOException {
    //        root = FXMLLoader.load(getClass().getResource("loginScreen.fxml"));
    //        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    //        scene = new Scene(root);
    //        stage.setScene(scene);
    //        stage.show();
    //    }

    public void switchToMainScreen(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("mainScreen.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
