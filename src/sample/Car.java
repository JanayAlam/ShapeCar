package sample;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

class Car extends Rectangle {
     Car(){
        super(50,75, Paint.valueOf("#1D89F3"));
        setX(275);
        setY(500);
    }
}
