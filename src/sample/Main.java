package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
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
        Scene menu=new Scene(root, 1280, 900);
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
        StartUpController controller=loader.getController();
        controller.setMain(this);
        Scene startUp=new Scene(root, 1280, 900);
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
        RoadLens[] l=new RoadLens[9];
        AnchorPane root=new AnchorPane();

        //Labels
        Label labelScoreName=new Label("Score");
        labelScoreName.setFont(new Font("Arial", 20));

        Label score=new Label("1506");
        score.setFont(new Font("Arial", 60));

        //Vbox
        VBox sideNote=new VBox(0);
        sideNote.setPrefSize(180,900);
        sideNote.setLayoutX(1010);
        sideNote.setLayoutY(10);
        sideNote.setPadding(new Insets(10,10,0,10));
        sideNote.getChildren().addAll(labelScoreName,score);

        //Background Image
        Image img=new Image("sample\\Road.png", 1000, 900, false, false);
        ImageView bg=new ImageView(img);

        //Car Create
        Car car=new Car();
        //car.setX(420);
        //car.setY(880);

        //Side lines
        SideLine left=new SideLine();
        left.setX(10);
        left.setY(0);

        SideLine right=new SideLine();
        right.setX(970);
        right.setY(0);

        //Road Lens
        for(int i=0;i<l.length;i++){
            l[i]=new RoadLens();
        }
        setScale(l);

        //AnchorPane settings
        root.getChildren().addAll(bg,car,left,right, sideNote);

        for(int i=0; i<l.length;i++){
            root.getChildren().add(l[i]);
        }

        //Creating Scene
        Scene scene=new Scene(root, 1280,900);

        //Controls
        scene.setOnKeyTyped(e->{
            if(e.getCharacter().equals("w")){
                if(car.getY()-15<=15){
                    car.setY(15);
                }else{
                    car.setY(car.getY()-15);
                }
            }else if(e.getCharacter().equals("s")){
                if(car.getY()+15>=780){
                    car.setY(780);
                }else{
                    car.setY(car.getY()+15);
                }
            }else if(e.getCharacter().equals("a")){
                if(car.getX()-15<=35){
                    car.setX(35);
                }else{
                    car.setX(car.getX()-15);
                }
            }else if(e.getCharacter().equals("d")){
                if(car.getX()+15>=890){
                    car.setX(890);
                }else{
                    car.setX(car.getX()+15);
                }
            }else if(e.getCharacter().equals(" ")){
                if(car.getY()-25<=15){
                    car.setY(15);
                }else{
                    car.setY(car.getY()-25);
                }
            }
        });

        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void setScale(RoadLens[] l){
        //Set Axis Y
        l[0].setY(530);
        l[1].setY(140);
        l[2].setY(-270);
        l[3].setY(700);
        l[4].setY(290);
        l[5].setY(-120);
        l[6].setY(530);
        l[7].setY(140);
        l[8].setY(-270);
        //Set Axis X
        for(int i=0;i<l.length;i++){
            if(i==0 || i==1 || i==2){
                l[i].setX(251.5);
            }else if(i==3 || i==4 || i==5){
                l[i].setX(491);
            }else if(i==6 || i==7 || i==8){
                l[i].setX(726);
            }
        }
    }

}
