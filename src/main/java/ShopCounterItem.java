import processing.core.PImage;

public class ShopCounterItem extends  Item {




    ShopCounterItem(PImage image){
        img = image;
        connectedFurniture = new ShopCounter(img);
        type = FurnitureTypes.shopCounter;

    }

    public void function() {

    }



}
