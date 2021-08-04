import processing.core.PApplet;
import processing.core.PImage;

public class ShopCounter extends Furniture {

    ShopCounter(PImage img){
        this.img = img;


    }


    void function(Main m){
        if (m.player.buildMode == false) {

            if(itemType !=Items.empty) {

            itemImg = null;
            Item temp = null;
                switch (itemType) {

                case primadonna:  {
                temp = new Primadonna(m.imgLoad.primadonna);
                }
                break;
                case cheddar: {
                    temp = new Cheddar(m.imgLoad.cheddar);
                }
                break;
                case pizzaTopping: {
                    temp = new PizzaTopping(m.imgLoad.pizzatopping);
                }
                break;


            }
            itemType = Items.empty;
                m.inventory.useBarList.get(0).useList.add(temp);


            }

                for (int i = 0; i < m.inventory.useBarList.size(); i++) {
                    if (m.inventory.useBarList.get(i).selected) {
                        itemType = m.inventory.useBarList.get(i).useList.get(i).itemType;
                        switch (itemType) {

                            case primadonna:  {
                                itemImg = m.player.imgLoad.primadonna;
                            }
                            break;
                            case cheddar: {
                                itemImg = m.player.imgLoad.cheddar;
                            }
                            break;
                            case pizzaTopping: {
                                itemImg = m.player.imgLoad.pizzatopping;
                            }
                            break;

                        }
                        m.inventory.useBarList.get(i).useList.remove(i);
                        m.inventory.useBarList.get(i).selected = false;


                    }

                }


            }

for (int i = 0;i<m.inventoryGrid.size();i++)
m.inventoryGrid.get(i).changeGridType();
}

    @Override
    void display(PApplet p, float x, float y) {
        super.display(p, x, y);
        if(itemType != Items.empty){
            p.image(itemImg,x+20,y+20);



        }
    }
}


