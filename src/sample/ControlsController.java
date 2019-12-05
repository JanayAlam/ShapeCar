package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ControlsController {
    Main main;
    @FXML
    private Button buttonBack;
    @FXML
    private Button buttonNewKeys;

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
    public  void newKey(){
        try{
            main.showNewKey();
        }catch (Exception i) {
            i.printStackTrace();
        }
    }
}
