package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
    private Stage window;
    public String user;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window=primaryStage;
        window.setTitle("Car Shape");
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
        Scene menu=new Scene(root, 1280, 720);
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
        Scene startUp=new Scene(root, 1280, 720);
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
        sideNote.setPrefSize(180,720);
        sideNote.setLayoutX(1010);
        sideNote.setLayoutY(10);
        sideNote.setPadding(new Insets(10,10,0,10));

        //Background Image
        Image img=new Image("sample\\Road.png", 1000, 720, false, false);
        ImageView bg=new ImageView(img);

        //ButtonBack
        Button buttonBackToMain=new Button("Main Menu");
        buttonBackToMain.setPrefSize(250,45);
        buttonBackToMain.setOnAction(e -> {
            try{
                showMenu(user);
            }catch (Exception i) {
                i.printStackTrace();
            }
        });

        sideNote.getChildren().addAll(labelScoreName,score,buttonBackToMain);

        //Car Create
        Car car=new Car();

        //Enemy
        Enemy e1=new Enemy();
        e1.setX(90.75);
        e1.setY(-700);

        Enemy e2=new Enemy();
        e2.setX(321.25);
        e2.setY(-400);

        Enemy e3=new Enemy();
        e3.setX(558.5);
        e3.setY(-200);

        Enemy e4=new Enemy();
        e4.setX(798);
        e4.setY(-1000);

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                e1.placementY();
                if(car.getX()<e1.getX()+e1.getWidth() && car.getY()<e1.getY()+e1.getHeight() && car.getY()+car.getHeight()>e1.getY() && car.getX()+car.getWidth()>e1.getX()){
                    System.out.println("Collision");
                }
                e2.placementY();
                if(car.getX()<e2.getX()+e2.getWidth() && car.getY()<e2.getY()+e2.getHeight() && car.getY()+car.getHeight()>e2.getY() && car.getX()+car.getWidth()>e2.getX()){
                    System.out.println("Collision");
                }
                e3.placementY();
                if(car.getX()<e3.getX()+e3.getWidth() && car.getY()<e3.getY()+e3.getHeight() && car.getY()+car.getHeight()>e3.getY() && car.getX()+car.getWidth()>e3.getX()){
                    System.out.println("Collision");
                }
                e4.placementY();
                if(car.getX()<e4.getX()+e4.getWidth() && car.getY()<e4.getY()+e4.getHeight() && car.getY()+car.getHeight()>e4.getY() && car.getX()+car.getWidth()>e4.getX()){
                    System.out.println("Collision");
                }

                l[0].placementY();
                l[1].placementY();
                l[2].placementY();
                l[3].placementY();
                l[4].placementY();
                l[5].placementY();
                l[6].placementY();
                l[7].placementY();
                l[8].placementY();
            }
        }.start();

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
        root.getChildren().addAll(bg, car, e1, e2, e3, e4, left, right, sideNote);

        for(int i=0; i<l.length;i++){
            root.getChildren().add(l[i]);
        }

        //Creating Scene
        Scene scene=new Scene(root, 1280,720);

        //Controls
        scene.setOnKeyTyped(e->{
            if(e.getCharacter().equals("w")){
                if(car.getY()-25<=25){
                    car.setY(25);
                }else{
                    car.setY(car.getY()-25);
                }
            }else if(e.getCharacter().equals("s")){
                if(car.getY()+25>=600){
                    car.setY(600);
                }else{
                    car.setY(car.getY()+25);
                }
            }else if(e.getCharacter().equals("a")){
                if(car.getX()-25<=35){
                    car.setX(35);
                }else{
                    car.setX(car.getX()-25);
                }
            }else if(e.getCharacter().equals("d")){
                if(car.getX()+25>=890){
                    car.setX(890);
                }else{
                    car.setX(car.getX()+25);
                }
            }else if(e.getCharacter().equals(" ")){
                if(car.getY()-35<=25){
                    car.setY(35);
                }else{
                    car.setY(car.getY()-35);
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
        l[0].setY(350);
        l[1].setY(-40);
        l[2].setY(-450);
        l[3].setY(500);
        l[4].setY(110);
        l[5].setY(-300);
        l[6].setY(350);
        l[7].setY(-40);
        l[8].setY(-450);
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
