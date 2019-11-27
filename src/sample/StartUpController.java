package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class StartUpController {

    private Main main;
    @FXML
    private TextField textFieldName;
    @FXML
    Button buttonPlay;

    public void setMain(Main main){
        this.main=main;
    }

    @FXML
    public void play(){
        String name=this.textFieldName.getText();
        try {
            main.showMenu(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
