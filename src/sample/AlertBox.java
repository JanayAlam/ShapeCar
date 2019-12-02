package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.text.Font;


public class AlertBox {

    static void Credits(){
        Stage popup= new Stage();
        popup.initModality(Modality.APPLICATION_MODAL);
        popup.setTitle("Credits");

        Label message=new Label();
        message.setText("DEVELOPER:\nRafsan Bari Shafin & Md Janay Alam\nICONS:\nwww.flaticon.com");
        message.setScaleX(1.25);
        message.setScaleY(1.25);
        Button buttonClose=new Button("Close");
        buttonClose.setPrefSize(75,30);
        buttonClose.setOnAction(e -> {
            popup.close();
        });

        VBox layout=new VBox();
        layout.getChildren().addAll(message,buttonClose);
        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(30);

        Scene scene=new Scene(layout, 450, 150);
        popup.setScene(scene);
        popup.setHeight(200);
        popup.setWidth(550);
        popup.showAndWait();
    }

    static void confirmBox(){
        Stage popup= new Stage();
        popup.initModality(Modality.APPLICATION_MODAL);
        popup.setTitle("Warning");
        popup.setMinWidth(450);
        popup.setMaxWidth(450);
        popup.setMinHeight(150);
        popup.setMaxHeight(150);

        VBox layout1=new VBox();
        HBox layout2=new HBox(4);

        //Labels
        Label header=new Label("ARE YOU SURE?");
        header.setPrefSize(200,50);
        header.setFont(new Font("Arial",22));
        header.autosize();
        Label text=new Label("Do you want to exit this program?");
        text.setFont(new Font("Arial",15));
        text.autosize();

        //Separator
        Separator separator=new Separator();
        separator.setLayoutX(0);

        //Buttons
        Button Exit=new Button("YES");
        Exit.setPrefSize(75,15);
        Exit.setOnAction(e ->{
            close();
        });
        Button Cancel=new Button("NO");
        Cancel.setPrefSize(75,30);
        Cancel.setOnAction(e ->{
            popup.close();
        });

        //Programs
        layout2.setAlignment(Pos.CENTER);
        layout1.setAlignment(Pos.TOP_LEFT);
        layout1.setPadding(new Insets (0,10,0,10));
        layout2.setPadding(new Insets (10,10,10,10));
        layout2.getChildren().addAll(Exit,Cancel);
        layout1.getChildren().addAll(header, separator, text, layout2);
        Scene scene=new Scene(layout1, 250, 70);
        popup.setScene(scene);
        popup.showAndWait();
    }

    static void close(){
        System.exit(0);
    }
}
