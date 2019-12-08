package sample;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Enemy extends Rectangle {
    private double n = 0.00001;

    public Enemy() {
        super(100, 130, Paint.valueOf("#FFFFFF"));
    }

    public void placementY() {
        if (n <= 4) {
            if (getY() >= 950) {
                setY(-250);
            } else {
                setY(getY() + (2 + n));
            }
            n += 0.00001;
        } else {
            if (getY() >= 950) {
                setY(-400);
            } else {
                setY(getY() + (2 + n));
            }
            n += 0.00005;
        }

        if(getX()==90.75 && getY()>950){
            setX(558.5);
        }else if(getX()==321.25 && getY()>950){
            setX(798);
        }else if(getX()==558.5 && getY()>950){
                setX(90.75);
        }else if(getX()==798 && getY()>950){
            setX(321.25);
        }

    }

}
