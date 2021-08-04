import processing.core.PImage;

public class WallItem extends Item {




    WallItem(PImage image){
        img = image;
        connectedFurniture = new Wall(img);
        type = FurnitureTypes.wall;

    }

    public void function() {

    }





}
