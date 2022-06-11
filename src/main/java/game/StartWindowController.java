package game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class StartWindowController {

    @FXML private Button startGameButton;


    public void initialize() {}

    //method called by the "startGameButton" : it switches the window to the StartGameWindow
    public void switchToGameWindow(ActionEvent event) throws IOException
    {
        Parent gameWindowFxml= FXMLLoader.load(getClass().getResource("GameWindow.fxml"));
        Stage gameWindow = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene gameScene = new Scene(gameWindowFxml);
        //gameScene.getStylesheets().add(getClass().getResource("gameWindowStylesheet.css").toExternalForm());
        gameWindow.setScene(gameScene);
        gameWindow.show();

    }
}
