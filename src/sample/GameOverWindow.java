package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class GameOverWindow {
    Main main;
    @FXML
    private Label labelScore;
    @FXML
    private Label labelUser;
    @FXML
    private Button buttonMainMenu;
    @FXML
    private Button buttonExit;
    @FXML
    private Button buttonReplay;

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
        AlertBox.confirmBox();
    }

    void labelUser(String name){
        this.labelUser.setText("Player Name: "+name);
    }

    void labelScore(int s){
        this.labelScore.setText(String.valueOf(s));
    }

    @FXML
    public void rePlay(){
        try {
            main.showNewGame();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
