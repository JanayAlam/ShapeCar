package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.*;

public class GameOverWindow {
    Main main;
    @FXML
    private Label labelScore;
    @FXML
    private Label labelUser;
    @FXML
    private Label hPlayer;
    @FXML
    private Label hScore;
    @FXML
    private Button buttonMainMenu;
    @FXML
    private Button buttonExit;
    @FXML
    private Button buttonReplay;

    void setMain(Main main){
        this.main=main;
    }

    /*
    void sethPlayer() throws Exception {
        //this.hPlayer.setText(name);
        File fr=new File("Text/BestPlayer.txt");
        Reader reader=new FileReader(fr);
        BufferedReader r=new BufferedReader(reader);
        while(true){
            String s=r.readLine();
            if(s==null){
                break;
            }
            this.hPlayer.setText(s);
        }
        r.close();
    }

    void sethScore() throws Exception {
        //this.hScore.setText(String.valueOf(i));
        File fr=new File("Text/HighestScore.txt");
        Reader reader=new FileReader(fr);
        BufferedReader r=new BufferedReader(reader);
        while(true){
            String s=r.readLine();
            if(s==null){
                break;
            }
            this.hScore.setText(s);
        }
        r.close();
    }
    */

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
