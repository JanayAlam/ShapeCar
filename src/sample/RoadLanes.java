package sample;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

class RoadLanes extends Rectangle {
     RoadLanes(){
        super(18,150,Paint.valueOf("#BF9117"));
    }
    public void placementY() {
         if(getY()>=720+100){
             setY(-250);
         }else{
             setY(getY()+0.5);
         }
    }
}
