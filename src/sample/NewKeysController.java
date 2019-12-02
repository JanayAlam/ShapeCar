package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class NewKeysController {
    Main main;
    @FXML
    Button backMainMenu;
    @FXML
    Button buttonBack;

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
}
