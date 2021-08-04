import processing.core.PApplet;

import java.util.ArrayList;

public class Inventory {

    PApplet p;
    Main m;

    ArrayList<Item> itemList = new ArrayList<>(50);
    ArrayList<Item> itemToolBarList = new ArrayList<>();
    ArrayList<Item> furnitureList = new ArrayList<>();
    ArrayList<ToolBar> toolBarList = new ArrayList<>();
    ArrayList<ToolBar> buildBarList = new ArrayList<>();
    ArrayList<ToolBar> useBarList = new ArrayList<>();

    ToolBar selected;




    Inventory(PApplet p, Main m ){
        this.p = p;
        this.m =m;
        for(int i = 0;i< 5;i++ ){
            toolBarList.add(new ToolBar(itemList, i,p));
            buildBarList.add(new ToolBar(furnitureList, i,p));
        }
    }


    void selector(boolean pressed,int mouseX,int mouseY,Inventory inventory ){
     //   if(pressed)

}

    void add(Item item,int number){

    for(int i=0;i<number;i++) {
        if(itemList.size()<50)
        itemList.add(item);
        else break;
    }
for(int i = 0; i<m.inventoryGrid.size();i++) {
    m.inventoryGrid.get(i).changeGridType();
}

    }

    void remove(Item item,int number){

        for(int i =itemList.size()-1;i>=0;i--){

            if(itemList.get(i) == item){
                itemList.remove(i);
                number--;
            }
            if (number == 0) break;
        }

    }



    void move(int from, int to, ArrayList<Item> itemList){
        Item temp = null;
        try{
            temp = itemList.get(to);

        }catch (Exception exception){
         //   System.out.println(exception);
        }
        try{
            itemList.set(to,itemList.get(from));

        }catch (Exception exception){
         //   System.out.println(exception);
        }

        if (temp!= null)
        itemList.set(from,temp);


    }

    void display(boolean buildMode,Player player,ArrayList<GridSpaceInventory> inventoryGridList){
        if(player.inventoryOpen) {
            p.fill(255);
            for(int i = 0; i<inventoryGridList.size();i++)
            inventoryGridList.get(i).display();

        }
            else{
            if (buildMode)
                useBarList = buildBarList;
            else useBarList = toolBarList;


            for (int i = 0; i < toolBarList.size(); i++)
                useBarList.get(i).displayToolBar();
        }

    }

    void open(Player player){

        player.immobile = true;
        player.inventoryOpen = true;



    }


    void close(Player player){

        player.immobile = false;
        player.inventoryOpen = false;


    }










}
