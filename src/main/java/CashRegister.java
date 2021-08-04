import processing.core.PImage;

public class CashRegister extends Furniture {


    CashRegister(PImage img){
        this.img = img;


    }

    void function(Main m){
int money = 0;
        for (int i=0;i<m.grid.size();i++){
            //System.out.println();

            if(m.grid.get(i).furnitureGridType == FurnitureTypes.shopCounter){

                switch(m.grid.get(i).furniture.itemType){
                    case primadonna:{
                        money = 100;
                    }break;
                    case cheddar:{
                        money = 50;

                    }break;
                    case pizzaTopping:{
                        money = 10;



                    }break;
                    default:{

                        money =0;

                    }
                }
                m.textList.add(new FloatyText(m.player.p,money,m.grid.get(i).x,m.grid.get(i).y));

                m.player.money += money;

                m.grid.get(i).furniture.itemType = Items.empty;
                m.grid.get(i).furniture.itemImg = null;

            }

        }



    }

}
