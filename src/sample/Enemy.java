package sample;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Enemy extends Rectangle {
    static double n=0.01;
    public Enemy(){
        super(100, 130, Paint.valueOf("#FFFFFF"));
    }
    static void placementY(Enemy e){
        if(n<=4){
            if(e.getY()>=930){
                e.setY(-250);
            }else{
                e.setY(e.getY()+(3+n));
            }
            n+=0.002;
        }else{
            if(e.getY()>=930){
                e.setY(-400);
            }else{
                e.setY(e.getY()+(3+n));
            }
            n+=0.001;
        }
    }
}
