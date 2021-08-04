import processing.core.PApplet;

public class GridSpace {


    float x,y,width,height;
    PApplet p;
    boolean pressed = false;

    boolean hasFurniture = false ;

    Items itemGridType = Items.empty;
    FurnitureTypes furnitureGridType = FurnitureTypes.empty;
    Furniture furniture;
    Item item;
    ImageLoader imgLoad;
    Inventory inventory;


    void changeGridType(Items newGridType) {

    }



    void pressed(float mX,float mY){
        if(((mX <(x+width)) && ((x< mX)) )&& ((mY < y + height) && (mY > y))){
           // System.out.println("New Check");

            function();



        }

    }


    void function(){

    }


    void display(){
        if(pressed) {
            p.stroke(255, 0, 0);
        p.strokeWeight(5);
        }
        else p.stroke(0,0,0);
        p.strokeWeight(1);
if(hasFurniture) {
    if (furnitureGridType != FurnitureTypes.empty)
        furniture.display(p, x, y);


}else{
   // System.out.println("Ture");
    p.rect(x,y,width,height);
    if (itemGridType != Items.empty) {
        item.display(p, x, y);
   //     System.out.println("true");
    }


}







    }
}
