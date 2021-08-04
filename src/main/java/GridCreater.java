import processing.core.PApplet;

import java.util.ArrayList;

public class GridCreater {
ImageLoader imgLoad;
Player player;



    ArrayList<GridSpaceDefault> createGrid(int width, int height, PApplet p, ImageLoader imgLoad, Inventory inventory, int gridNumberX,int gridNumberY, boolean fill , int offset,Player player){
        this.imgLoad = imgLoad;
this.player = player;
        ArrayList<GridSpaceDefault> grid = new ArrayList<>();

        for(int i =0;i<gridNumberX;i++){
        grid.add(new GridSpaceDefault(offset+(width/gridNumberX)*i,offset+(height/gridNumberX)*0,width/gridNumberX,height/gridNumberY,p,imgLoad,inventory,player));
        for(int i2 = 1;i2<gridNumberY ;i2++)
            grid.add(new GridSpaceDefault(offset+(width/gridNumberX)*i,offset+(height/gridNumberY)*i2,width/gridNumberX,height/gridNumberY,p,imgLoad,inventory,player));
        }

    return grid;




    }

    ArrayList<GridSpaceInventory> createGridInventory(int width, int height, PApplet p, ImageLoader imgLoad, Inventory inventory, int gridNumberX,int gridNumberY, boolean fill , int offset){
        this.imgLoad = imgLoad;
        int count = 0;

        ArrayList<GridSpaceInventory> grid = new ArrayList<>();

        for(int i =0;i<gridNumberX;i++){
            grid.add(new GridSpaceInventory(offset+(width/gridNumberX)*i,offset+(offset+height/gridNumberX)*0,width/gridNumberX,height/gridNumberX,p,imgLoad,inventory,count));
            count++;
            for(int i2 = 1;i2<gridNumberY ;i2++) {
                grid.add(new GridSpaceInventory(offset + (width / gridNumberX) * i, offset + (height / gridNumberY) * i2, width / gridNumberX, height / gridNumberY, p, imgLoad, inventory, count));
                count++;
            }
        }

        return grid;




    }



}
