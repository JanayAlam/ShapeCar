package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MenuController {
    private Main main;

    @FXML
    private Label labelWelcome;
    @FXML
    private Button buttonNewGame;
    @FXML
    private Button labelControlKeys;
    @FXML
    private Button buttonCredits;
    @FXML
    private Button buttonExit;


    public void setMain(Main main){
        this.main=main;
    }

    public void labelWelcome(String name){
        this.labelWelcome.setText("Welcome, "+name);
    }

    @FXML
    public void setButtonExit(ActionEvent event){
        AlertBox.confirmBox();
    }

    @FXML
    public void setCredits(){
        main.showCredits();
    }

    @FXML
    public void setNewGame(){

        try {
            main.showNewGame();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
