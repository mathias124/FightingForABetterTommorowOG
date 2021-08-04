import processing.core.PApplet;

import java.util.ArrayList;

public class Shop {

    ArrayList<Furniture> furnitureList;
    ArrayList<GridSpaceDefault> grid;


    Shop(ArrayList<Furniture> furnitureList, ArrayList<GridSpaceDefault> grid) {
        this.furnitureList = furnitureList;
        this.grid = grid;


    }

    void shopFunction(Main m, PApplet p) {
        p.background(m.imgLoad.shopBackground);

        float nearestFurniture= 75;
        int furnitureCount =-1;
        for (int i = 0; grid.size() > i; i++) {

        m.player.p.fill(0);
            grid.get(i).display();
            if( grid.get(i).furnitureGridType == FurnitureTypes.empty||grid.get(i).furnitureGridType == FurnitureTypes.floor)
            if(isFloor(i)) {

                grid.get(i).furnitureGridType = FurnitureTypes.floor;
                grid.get(i).furniture = new Floor(m.imgLoad.floor);
            }else if(grid.get(i).furnitureGridType == FurnitureTypes.floor){
                grid.get(i).furnitureGridType = FurnitureTypes.empty;
            }
            if(grid.get(i).furniture != null){
            float temp = grid.get(i).furniture.playerNearby(m.player,grid.get(i).x,grid.get(i).y,m.player.width,m.player.height,grid.get(i).width,grid.get(i).height);
            if (temp !=-1&&temp<nearestFurniture) {
                nearestFurniture = temp;
                furnitureCount = i;

            }

        }}
        if (m.player.activate&&furnitureCount!=-1)
            grid.get(furnitureCount).furniture.function(m);



        m.player.activate = false;
        m.player.display();



    }

    boolean isFloor(int baseI ){

        boolean left = false ,right = false,up = false,down = false;
        if(grid.get(baseI).furnitureGridType== FurnitureTypes.door ||grid.get(baseI).furnitureGridType== FurnitureTypes.wall)
            return false;



        int i = baseI-1;
        while((i+1)%12!=0){
            if(grid.get(i).furnitureGridType == FurnitureTypes.wall||grid.get(i).furnitureGridType == FurnitureTypes.door) {
                left = true;

            }
            i-=1;
        }
        if(left==false)
            return false;
        i = baseI+1;
        while((i)%12!=0){
            if(grid.get(i).furnitureGridType == FurnitureTypes.wall||grid.get(i).furnitureGridType == FurnitureTypes.door) {
                right = true;
            }
            i+=1;
        }
        if(right == false)
            return false;

        i = baseI+12;
        while(i<240){
            if(grid.get(i).furnitureGridType == FurnitureTypes.wall||grid.get(i).furnitureGridType == FurnitureTypes.door) {
                up = true;
            }
            i+=12;
        }
        if(up == false) {
           // System.out.println("up");
            return false;
        }
        i = baseI-12;

        while(i>0){
            if(grid.get(i).furnitureGridType == FurnitureTypes.wall||grid.get(i).furnitureGridType == FurnitureTypes.door) {
                down = true;
            }
            i-=12;
        }
        if(down == false){
           // System.out.println("down");
            return false;

    }


        return true;

    }


}
