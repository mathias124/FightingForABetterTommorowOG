import processing.core.PApplet;

import java.util.ArrayList;

public class GridSpaceInventory extends GridSpace {

int count;

    GridSpaceInventory(float x, float y, float width, float height, PApplet p, ImageLoader imgLoad, Inventory inventory,int i){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.p=p;
        this.imgLoad = imgLoad;
        this.inventory = inventory;
        count = i;
        hasFurniture = false;
        changeGridType();

    }

    @Override
    public void function() {
      //  System.out.println("Check");
    pressed    = !pressed;
    checkPress();
    }

    void changeGridType(){
        if(inventory.itemList.size()>count) {
            if (inventory.itemList.get(count).itemType != null)
                itemGridType = inventory.itemList.get(count).itemType;
        }
else itemGridType =Items.empty;
//System.out.println(count);

        switch (itemGridType) {



            case doorItem:{
                item= new DoorItem(imgLoad.door);

            }break;

            case cashRegisterItem:{
                item= new CashRegisterItem(imgLoad.cashRegister);

            }break;

            case shopCounterItem:{
                item = new ShopCounterItem(imgLoad.shopCounter);
            }break;

            case wallItem: {
                item = new WallItem(imgLoad.wall);
            }break;

            case pizzaTopping:{
                item = new PizzaTopping(imgLoad.pizzatopping);
            }break;
            case cheddar:{
                item = new Cheddar(imgLoad.cheddar);


            }break;
            case primadonna:{

                item = new Primadonna(imgLoad.primadonna);

            }break;

            default:{
                furniture = null;

            }break;
        }


    }

    void checkPress(){
      //  System.out.println("check");
        int pressCount = 2;
        int[] gridSpaces = new int[2];
        for(int i = 0; i<inventory.m.inventoryGrid.size();i++){
            if(inventory.m.inventoryGrid.get(i).pressed) {
                pressCount--;
                gridSpaces[pressCount] = i;
            }
            if(pressCount ==0){
                inventory.move(gridSpaces[1],gridSpaces[0],inventory.itemList);
                inventory.m.inventoryGrid.get(gridSpaces[0]).pressed = false;
                inventory.m.inventoryGrid.get(gridSpaces[1]).pressed = false;
                for (int i2 = 0;inventory.m.inventoryGrid.size()>i2;i2++)
                inventory.m.inventoryGrid.get(i2).changeGridType();

                break;
            }

        }

    }



}
