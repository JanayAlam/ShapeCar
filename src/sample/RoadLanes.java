package sample;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

class RoadLanes extends Rectangle {
     RoadLanes(){
        super(18,200,Paint.valueOf("#BF9117"));
    }
    public void placementY() {
         if(getY()>=720+150){
             setY(-270);
         }else{
             setY(getY()+0.3);
         }
    }
}
