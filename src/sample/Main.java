package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.*;

public class Main extends Application {
    private Stage window;
    String user;
    int s=0;
    private String upKey="w";
    private String downKey="s";
    private String leftKey="a";
    private String rightKey="d";
    String name="";
    private int highestScore;
    private boolean status=false;

    public Main() throws IOException {
    }

    //Setter
    public void setUpKey(String up) {
        this.upKey = up;
    }

    public void setDownKey(String down) {
        this.downKey = down;
    }

    public void setLeftKey(String left) {
        this.leftKey = left;
    }

    public void setRightKey(String right) {
        this.rightKey = right;
    }

    //Getter
    public String getUpKey() {
        return upKey;
    }

    public String getDownKey() {
        return downKey;
    }

    public String getLeftKey() {
        return leftKey;
    }

    public String getRightKey() {
        return rightKey;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        window=primaryStage;
        window.setTitle("ShapeCars");
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
        if(name.equals("")){
            this.user="User";
        }else{
            this.user=name;
        }
        controller.labelWelcome(this.user);

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
        status=false;
        s=0;
        RoadLanes[] l=new RoadLanes[9];
        AnchorPane root=new AnchorPane();

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
        buttonBackToMain.setAlignment(Pos.CENTER);
        buttonBackToMain.setOnAction(e -> {
            try{
                status=true;
                showMenu(user);
            }catch (Exception i) {
                i.printStackTrace();
            }
        });

        Button buttonBackToDesktop=new Button("EXIT");
        buttonBackToDesktop.setPrefSize(250,45);
        buttonBackToDesktop.setAlignment(Pos.CENTER);
        buttonBackToDesktop.setOnAction(e -> {
            AlertBox.confirmBox();
        });

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

        //Labels
        Label labelScoreName=new Label("Score");
        labelScoreName.setFont(new Font("Arial", 20));
        Label score=new Label(String.valueOf(s));
        score.setFont(new Font("Arial", 60));


        new AnimationTimer() {

            @Override
            public void handle(long now) {
                if (status==false){
                    //Controls
                    e1.placementY();
                    if(e1.getY()>=720 && e1.getY()<=722){
                        s+=1;
                        score.setText(String.valueOf(s));
                    }
                    if(car.getX()<e1.getX()+e1.getWidth() && car.getY()<e1.getY()+e1.getHeight() && car.getY()+car.getHeight()>e1.getY() && car.getX()+car.getWidth()>e1.getX()){
                        try{
                            gameOver();
                        }catch (Exception i) {
                            i.printStackTrace();
                        }
                        stop();
                    }
                    e2.placementY();
                    if(e2.getY()>=720 && e2.getY()<=722){
                        s+=1;
                        score.setText(String.valueOf(s));
                    }
                    if(car.getX()<e2.getX()+e2.getWidth() && car.getY()<e2.getY()+e2.getHeight() && car.getY()+car.getHeight()>e2.getY() && car.getX()+car.getWidth()>e2.getX()){
                        try{
                            gameOver();
                        }catch (Exception i) {
                            i.printStackTrace();
                        }
                        stop();
                    }

                    e3.placementY();
                    if(e3.getY()>=720 && e3.getY()<=722){
                        s+=1;
                        score.setText(String.valueOf(s));
                    }
                    if(car.getX()<e3.getX()+e3.getWidth() && car.getY()<e3.getY()+e3.getHeight() && car.getY()+car.getHeight()>e3.getY() && car.getX()+car.getWidth()>e3.getX()){
                        try{
                            gameOver();
                        }catch (Exception i) {
                            i.printStackTrace();
                        }
                        stop();
                    }

                    e4.placementY();
                    if(e4.getY()>=720 && e4.getY()<=722){
                        s+=1;
                        score.setText(String.valueOf(s));
                    }
                    if(car.getX()<e4.getX()+e4.getWidth() && car.getY()<e4.getY()+e4.getHeight() && car.getY()+car.getHeight()>e4.getY() && car.getX()+car.getWidth()>e4.getX()){
                        try{
                            gameOver();
                        }catch (Exception i) {
                            i.printStackTrace();
                        }
                        stop();
                    }

                    //RoadLens
                    l[0].placementY();
                    if(car.getX()<l[0].getX()+l[0].getWidth() && car.getY()<l[0].getY()+l[0].getHeight() && car.getY()+car.getHeight()>l[0].getY() && car.getX()+car.getWidth()>l[0].getX()){
                        try{
                            gameOver();
                        }catch (Exception i) {
                            i.printStackTrace();
                        }
                        stop();
                    }

                    l[1].placementY();
                    if(car.getX()<l[1].getX()+l[1].getWidth() && car.getY()<l[1].getY()+l[1].getHeight() && car.getY()+car.getHeight()>l[1].getY() && car.getX()+car.getWidth()>l[1].getX()){
                        try{
                            gameOver();
                        }catch (Exception i) {
                            i.printStackTrace();
                        }
                        stop();
                    }

                    l[2].placementY();
                    if(car.getX()<l[2].getX()+l[2].getWidth() && car.getY()<l[2].getY()+l[2].getHeight() && car.getY()+car.getHeight()>l[2].getY() && car.getX()+car.getWidth()>l[2].getX()){
                        try{
                            gameOver();
                        }catch (Exception i) {
                            i.printStackTrace();
                        }
                        stop();
                    }

                    l[3].placementY();
                    if(car.getX()<l[3].getX()+l[3].getWidth() && car.getY()<l[3].getY()+l[3].getHeight() && car.getY()+car.getHeight()>l[3].getY() && car.getX()+car.getWidth()>l[3].getX()){
                        try{
                            gameOver();
                        }catch (Exception i) {
                            i.printStackTrace();
                        }
                        stop();
                    }

                    l[4].placementY();
                    if(car.getX()<l[4].getX()+l[4].getWidth() && car.getY()<l[4].getY()+l[4].getHeight() && car.getY()+car.getHeight()>l[4].getY() && car.getX()+car.getWidth()>l[4].getX()){
                        try{
                            gameOver();
                        }catch (Exception i) {
                            i.printStackTrace();
                        }
                        stop();
                    }

                    l[5].placementY();
                    if(car.getX()<l[5].getX()+l[5].getWidth() && car.getY()<l[5].getY()+l[5].getHeight() && car.getY()+car.getHeight()>l[5].getY() && car.getX()+car.getWidth()>l[5].getX()){
                        try{
                            gameOver();
                        }catch (Exception i) {
                            i.printStackTrace();
                        }
                        stop();
                    }

                    l[6].placementY();
                    if(car.getX()<l[6].getX()+l[6].getWidth() && car.getY()<l[6].getY()+l[6].getHeight() && car.getY()+car.getHeight()>l[6].getY() && car.getX()+car.getWidth()>l[6].getX()){
                        try{
                            gameOver();
                        }catch (Exception i) {
                            i.printStackTrace();
                        }
                        stop();
                    }
                    l[7].placementY();
                    if(car.getX()<l[7].getX()+l[7].getWidth() && car.getY()<l[7].getY()+l[7].getHeight() && car.getY()+car.getHeight()>l[7].getY() && car.getX()+car.getWidth()>l[7].getX()){
                        try{
                            gameOver();
                        }catch (Exception i) {
                            i.printStackTrace();
                        }
                        stop();
                    }

                    l[8].placementY();
                    if(car.getX()<l[8].getX()+l[8].getWidth() && car.getY()<l[8].getY()+l[8].getHeight() && car.getY()+car.getHeight()>l[8].getY() && car.getX()+car.getWidth()>l[8].getX()){
                        try{
                            gameOver();
                        }catch (Exception i) {
                            i.printStackTrace();
                        }
                        stop();
                    }
                }
            }
        }.start();

        //VBox
        sideNote.getChildren().addAll(labelScoreName,score,buttonBackToMain,buttonBackToDesktop);

        //Side lines
        SideLine leftLine=new SideLine();
        leftLine.setX(10);
        leftLine.setY(0);

        SideLine rightLine=new SideLine();
        rightLine.setX(970);
        rightLine.setY(0);

        //Road Lens
        for(int i=0;i<l.length;i++){
            l[i]=new RoadLanes();
        }
        setScale(l);

        //AnchorPane settings
        root.getChildren().addAll(bg, e1, e2, e3, e4, leftLine, rightLine, sideNote);

        for(int i=0; i<l.length;i++){
            root.getChildren().add(l[i]);
        }
        root.getChildren().add(car);

        //Creating Scene
        Scene scene=new Scene(root, 1280,720);

        //Controls
        scene.setOnKeyTyped(e->{
            if(e.getCharacter().equals(this.upKey)){
                if(car.getY()-25<=25){
                    car.setY(25);
                }else{
                    car.setY(car.getY()-25);
                }
            }else if(e.getCharacter().equals(this.downKey)){
                if(car.getY()+25>=600){
                    car.setY(600);
                }else{
                    car.setY(car.getY()+25);
                }
            }else if(e.getCharacter().equals(this.leftKey)){
                if(car.getX()-25<=35){
                    car.setX(35);
                }else{
                    car.setX(car.getX()-25);
                }
            }else if(e.getCharacter().equals(this.rightKey)){
                if(car.getX()+25>=890){
                    car.setX(890);
                }else{
                    car.setX(car.getX()+25);
                }
            }
        });

        window.setScene(scene);
        window.show();
    }

    void showControl() throws Exception{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("Controls.fxml"));
        Parent root= loader.load();
        Scene control=new Scene(root, 1280, 720);
        ControlsController controller=loader.getController();
        controller.setMain(this);
        controller.setLabelUp();
        controller.setLabelDown();
        controller.setLabelRight();
        controller.setLabelLeft();
        window.setScene(control);
        window.setOnCloseRequest( e -> {
            e.consume();
            AlertBox.confirmBox();
        });
        window.show();
    }

    void showNewKey() throws Exception{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("NewKeys.fxml"));
        Parent root= loader.load();
        Scene KeysControl=new Scene(root, 1280, 720);
        NewKeysController controller=loader.getController();
        controller.setMain(this);
        controller.fieldUp.setPromptText(this.upKey);
        controller.fieldDown.setPromptText(this.downKey);
        controller.fieldRight.setPromptText(this.rightKey);
        controller.fieldLeft.setPromptText(this.leftKey);
        window.setScene(KeysControl);
        window.setOnCloseRequest( e -> {
            e.consume();
            AlertBox.confirmBox();
        });
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void setScale(RoadLanes[] l){
        //Set Axis Y
        l[0].setY(720-150);
        l[1].setY(l[0].getY()-150-200);
        l[2].setY(l[1].getY()-150-200);
        l[3].setY(720-300);
        l[4].setY(l[3].getY()-150-200);
        l[5].setY(l[4].getY()-150-200);
        l[6].setY(720-150);
        l[7].setY(l[6].getY()-150-200);
        l[8].setY(l[7].getY()-150-200);
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


    void gameOver() throws Exception{
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("GameOverWindow.fxml"));
        Parent root= loader.load();
        GameOverWindow controller=loader.getController();
        controller.setMain(this);
        controller.labelUser(this.user);
        controller.labelScore(this.s);

        /*File read=new File("Text/HighestScore.txt");
        File write=new File("Text/BestPlayer.txt");
        File writeScore=new File("Text/HighestScore.txt");
        Reader r=new FileReader(read);
        Writer w1=new FileWriter(write);
        Writer w2=new FileWriter(writeScore);
        BufferedReader br=new BufferedReader(r);
        int score=0;
        while(true){
            String s=br.readLine();
            System.out.println(s);
            score=Integer.valueOf(s);
            if(s==null){
                break;
            }
        }
        r.close();


        if(this.s>score){
            w1.write(user);
            w2.write(String.valueOf(s));
            w1.close();
            w2.close();
        }

        controller.sethPlayer();
        controller.sethScore();*/

        Scene gameOver=new Scene(root, 1280, 720);
        window.setScene(gameOver);
        window.show();
    }
}
