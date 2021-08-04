import processing.core.PImage;

public class DoorItem extends Item {





        DoorItem(PImage image){
            img = image;
            connectedFurniture = new Door(image);
             type = FurnitureTypes.door;

        }

        public void function() {

        }






}
