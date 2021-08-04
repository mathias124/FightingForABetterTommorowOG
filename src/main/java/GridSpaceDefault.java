import processing.core.PApplet;

public class GridSpaceDefault extends GridSpace{

GridSpaceDefault(){}
Player player;
GridSpaceDefault(float x, float y, float width, float height, PApplet p, ImageLoader imgLoad, Inventory inventory,Player player){
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    this.p=p;
    this.imgLoad = imgLoad;
    this.inventory = inventory;
    this.player = player;
    hasFurniture = true;

}

    void changeGridType(FurnitureTypes newGridType){

        furnitureGridType = newGridType;

        switch (furnitureGridType) {

            case empty:{

                furniture = null;

            }break;

            case door:{
                furniture= new Door(imgLoad.door);

            }break;

            case cashRegister:{
                furniture= new CashRegister(imgLoad.cashRegister);

            }break;

            case shopCounter:{
                furniture = new ShopCounter(imgLoad.shopCounter);
            }break;

            case wall:{}
            furniture = new Wall(imgLoad.wall);

        }

    }




    void function(){
    if(player.buildMode) {
        for (int i = 0; i < inventory.buildBarList.size(); i++)
            if (inventory.buildBarList.get(i).selected == true)
                if (furnitureGridType != inventory.furnitureList.get(i).getType())
                    changeGridType(inventory.furnitureList.get(i).getType());
                else
                    changeGridType(FurnitureTypes.empty);
    }
    }









    }






