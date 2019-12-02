package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class GameOverWindow {
    Main main;
    @FXML
    Label labelScore;
    @FXML
    Label labelUser;
    @FXML
    Button buttonMainMenu;
    @FXML
    Button buttonExit;

    public void setMain(Main main){
        this.main=main;
    }

    @FXML
    public void back(){
        try{
            main.showMenu(main.user);
        }catch (Exception i) {
            i.printStackTrace();
        }
    }

    @FXML
    public void exit(){
        System.exit(0);
    }
}
