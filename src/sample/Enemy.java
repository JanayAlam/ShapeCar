package sample;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Enemy extends Rectangle {
    double n = 0.00001;

    public Enemy() {
        super(100, 130, Paint.valueOf("#FFFFFF"));
    }

    public void placementY() {
        if (n <= 4) {
            if (getY() >= 1000) {
                setY(-250);
            } else {
                setY(getY() + (2 + n));
            }
            n += 0.00001;
        } else {
            if (getY() >= 1000) {
                setY(-400);
            } else {
                setY(getY() + (2 + n));
            }
            n += 0.00005;
        }
        if(getX()==90.75 && getY()>1000){
            setX(558.5);
        }else if(getX()==321.25 && getY()>1000){
            setX(798);
        }else if(getX()==558.5 && getY()>1000){
            setX(90.75);
        }else if(getX()==798 && getY()>1000){
            setX(321.25);
        }

        /*int max = 4;
        int min = 1;
        int range = max - min + 1;
        for (int i = 0; i < 10; i++) {
            int rand = (int) (Math.random() * range) + min;
            if(getY()>1000){
                if (rand == 1) {
                    setX(321.25);
                } else if (rand == 2) {
                    setX(798);
                } else if (rand == 3) {
                    setX(90.75);
                } else if (rand == 4) {
                    setX(558.5);
                }
            }
        }*/
    }
}
