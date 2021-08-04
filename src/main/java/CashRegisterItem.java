import processing.core.PImage;

public class CashRegisterItem extends Item {

    CashRegisterItem(PImage image){
        img = image;
        connectedFurniture = new CashRegister(img);
        type = FurnitureTypes.cashRegister;

    }




}
