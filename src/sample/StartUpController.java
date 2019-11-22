package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class StartUpController {

    private Main main;
    @FXML
    private TextField textFieldName;
    @FXML
    private Button buttonPlay;

    public void setMain(Main main){
        this.main=main;
    }

    @FXML
    public void play(ActionEvent event){
        String name=this.textFieldName.getText();
        try {
            main.showMenu(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
