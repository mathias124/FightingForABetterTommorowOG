import processing.core.PApplet;
import processing.core.PImage;

public class Item {

    PImage img;
    FurnitureTypes type;
    Items itemType;
    ImageLoader il;
    Furniture connectedFurniture;


    void function(){


    }

    public void display(PApplet p, float x, float y){
        p.image(img,x,y);


    }

    public PImage getImg() {
        return img;
    }

    public FurnitureTypes getType(){return type; }

}
