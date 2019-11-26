package sample;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

class RoadLens extends Rectangle {
     RoadLens(){
        super(18,200,Paint.valueOf("#BF9117"));
    }
    public void placementY() {
         if(getY()>=900+150){
             setY(-270);
         }else{
             setY(getY()+0.3);
         }
    }
}
