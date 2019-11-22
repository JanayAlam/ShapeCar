package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;


public class newGameController {
    private Main main;
    @FXML
    Rectangle player;
    @FXML
    Button buttonMainMenu;

    public void setMain(Main main) {
        this.main = main;
    }
    @FXML
    public void backMenu(){
        try {
            main.showMenu(main.user);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
