package game;

import game.Game.ObjectType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class GameWindowController {

    @FXML private Text winnerText;
    @FXML private ImageView rockImageView;
    @FXML private ImageView paperImageView;
    @FXML private ImageView scissorImageView;

    private Game game;
    private Player user;
    private Player machine;

    public void initialize() {
        this.game = new Game();
        this.user = new Player();
        this.machine = new Player();
    }

    public void rockIsClicked(MouseEvent event) throws IOException
    {
        checkMancheWinner(ObjectType.ROCK , randomMachineObject());
    }
    public void scissorIsClicked(MouseEvent event) throws IOException
    {
        checkMancheWinner(ObjectType.SCISSOR , randomMachineObject());
    }
    public void paperIsClicked(MouseEvent event) throws IOException
    {
        checkMancheWinner(ObjectType.PAPER , randomMachineObject());
    }


    public ObjectType randomMachineObject()
    {
        return game.getRandomObject();
    }


    public void checkMancheWinner(ObjectType userChosenObject , ObjectType machineChosenObject) throws IOException {

        if (userChosenObject == ObjectType.PAPER && machineChosenObject == ObjectType.ROCK) {
            user.mancheWon();
            System.out.println("USER VICTORIES : " + user.getVictories());
            checkGameWinner();
            winnerText.setText("You won!");
        }

        if (userChosenObject == ObjectType.PAPER && machineChosenObject == ObjectType.SCISSOR) {
            machine.mancheWon();
            System.out.println("MACHINE VICTORIES : " + machine.getVictories());
            checkGameWinner();
            winnerText.setText("Machine won :(");
        }

        //case same chosen Object
        if (userChosenObject == ObjectType.PAPER && machineChosenObject == ObjectType.PAPER) {
            winnerText.setText("Tie");
        }

        if (userChosenObject == ObjectType.ROCK && machineChosenObject == ObjectType.PAPER) {
            machine.mancheWon();
            System.out.println("MACHINE VICTORIES : " + machine.getVictories());
            checkGameWinner();
            winnerText.setText("Machine won :(");
        }


        if (userChosenObject == ObjectType.ROCK && machineChosenObject == ObjectType.SCISSOR) {
            user.mancheWon();
            System.out.println("USER VICTORIES : " + user.getVictories());
            checkGameWinner();
            winnerText.setText("You won!");
        }
        //case same chosen Object
        if (userChosenObject == ObjectType.ROCK && machineChosenObject == ObjectType.ROCK) {
            winnerText.setText("Tie");
        }

        if (userChosenObject == ObjectType.SCISSOR && machineChosenObject == ObjectType.PAPER) {
            user.mancheWon();
            System.out.println("USER VICTORIES : " + user.getVictories());
            checkGameWinner();
            winnerText.setText("You won!");
        }

        if (userChosenObject == ObjectType.SCISSOR && machineChosenObject == ObjectType.ROCK) {
            machine.mancheWon();
            System.out.println("MACHINE VICTORIES : " + machine.getVictories());
            checkGameWinner();
            winnerText.setText("Machine won :(");
        }

        //case same chosen Object
        if (userChosenObject == ObjectType.SCISSOR && machineChosenObject == ObjectType.SCISSOR) {
            winnerText.setText("Tie");
        }



    }

    public void checkGameWinner() throws IOException {
        if (user.getVictories() == 3) {
            switchToYouWonWindow();
        }

        if(machine.getVictories() == 3)
        {
           switchToMachineWonWindow();
        }
    }

    public void switchToYouWonWindow() throws IOException
    {
        Parent fxml = FXMLLoader.load(getClass().getResource("YouWonWindow.fxml"));
        Stage youWonWindow = (Stage) winnerText.getScene().getWindow(); // return on the current stage
        Scene youWonScene = new Scene(fxml);
        youWonWindow.setScene(youWonScene);
        youWonWindow.show();


    }


    public void switchToMachineWonWindow() throws IOException
    {
        Parent fxml = FXMLLoader.load(getClass().getResource("MachineWonWindow.fxml"));
        Stage machineWonWindow = (Stage) winnerText.getScene().getWindow();
        Scene machineWonScene = new Scene(fxml);
        machineWonWindow.setScene(machineWonScene);
        machineWonWindow.show();

    }





}
