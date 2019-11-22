package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main extends Application {
    Stage window;
    public String user;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window=primaryStage;
        window.setTitle("Shape Cars");
        window.setOnCloseRequest( e -> {
            e.consume();
            AlertBox.confirmBox();
        });
        showStartUp();
    }

    public void showMenu(String name) throws Exception{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("Menu.fxml"));
        Parent root= loader.load();
        Scene menu=new Scene(root, 720, 600);
        MenuController controller=loader.getController();
        controller.setMain(this);
        controller.labelWelcome(name);
        this.user=name;

        window.setScene(menu);
        window.setOnCloseRequest( e -> {
                e.consume();
                AlertBox.confirmBox();
        });
        window.show();
    }

    public void showStartUp() throws Exception{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("StartUp.fxml"));
        Parent root= loader.load();
        Scene startUp=new Scene(root, 720, 600);
        StartUpController controller=loader.getController();
        controller.setMain(this);

        window.setScene(startUp);
        window.setOnCloseRequest( e -> {
            e.consume();
            AlertBox.confirmBox();
        });
        window.show();
    }

    public void showCredits(){
        AlertBox.Credits();
    }

    public void showNewGame() throws Exception{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("newGame.fxml"));
        Parent root= loader.load();
        Scene game=new Scene(root, 720, 600);
        newGameController controller=loader.getController();
        controller.setMain(this);

        game.setOnKeyTyped(e -> {
            if(e.getCharacter().equals("w")){
                if(controller.player.getLayoutY()==250){
                    controller.player.setLayoutY(250);
                }else{
                    controller.player.setLayoutY(controller.player.getLayoutY() - 5);
                }
            }else if(e.getCharacter().equals("s")){
                if(controller.player.getLayoutY()==520){
                    controller.player.setLayoutY(520);
                }else{
                    controller.player.setLayoutY(controller.player.getLayoutY() + 5);
                }
            }else if(e.getCharacter().equals("a")){
                if(controller.player.getLayoutX()==5){
                    controller.player.setLayoutX(5);
                }else{
                    controller.player.setLayoutX(controller.player.getLayoutX() - 5);
                }
            }else if(e.getCharacter().equals("d")){
                if(controller.player.getLayoutX()==445){
                    controller.player.setLayoutX(445);
                }else{
                    controller.player.setLayoutX(controller.player.getLayoutX() + 5);
                }
            }
        });
        window.setScene(game);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
