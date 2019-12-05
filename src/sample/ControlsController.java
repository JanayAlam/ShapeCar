package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ControlsController {
    Main main;
    @FXML
    private Button buttonBack;
    @FXML
    private Button buttonNewKeys;
    @FXML
    private Label labelUp;
    @FXML
    private Label labelDown;
    @FXML
    private Label labelRight;
    @FXML
    private Label labelLeft;

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
    public void newKey(){
        try{
            main.showNewKey();
        }catch (Exception i) {
            i.printStackTrace();
        }
    }

    public void setLabelUp(){
        this.labelUp.setText(main.upKey);
    }
    public void setLabelDown(){
        this.labelDown.setText(main.downKey);
    }
    public void setLabelRight(){
        this.labelRight.setText(main.rightKey);
    }
    public void setLabelLeft(){
        this.labelLeft.setText(main.leftKey);
    }
}
