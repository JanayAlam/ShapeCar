package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class NewKeysController {
    Main main;
    @FXML
    Button backMainMenu;
    @FXML
    Button buttonBack;
    @FXML
    TextField fieldUp;
    @FXML
    TextField fieldDown;
    @FXML
    TextField fieldRight;
    @FXML
    TextField fieldLeft;
    @FXML
    Button saveUp;
    @FXML
    Button saveDown;
    @FXML
    Button saveRight;
    @FXML
    Button saveLeft;

    public void setMain(Main main){
        this.main=main;
    }

    @FXML
    public void buttonBack(){
        try{
            main.showControl();
        }catch (Exception i) {
            i.printStackTrace();
        }
    }

    @FXML
    public void backMainMenu(){
        try{
            main.showMenu(main.user);
        }catch (Exception i) {
            i.printStackTrace();
        }
    }

    @FXML
    public void reset(){
        main.setUpKey("w");
        main.setDownKey("s");
        main.setRightKey("d");
        main.setLeftKey("a");
        fieldUp.setPromptText("w");
        fieldDown.setPromptText("s");
        fieldRight.setPromptText("d");
        fieldLeft.setPromptText("a");
    }

    @FXML
    public void saveUpKey(){
        main.setUpKey(fieldUp.getText());
    }
    @FXML
    public void saveDownKey(){
        main.setDownKey(fieldDown.getText());
    }
    @FXML
    public void saveRightKey(){
        main.setRightKey(fieldRight.getText());
    }
    @FXML
    public void saveLeftKey(){
        main.setLeftKey(fieldLeft.getText());
    }

}
