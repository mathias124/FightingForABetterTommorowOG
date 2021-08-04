import processing.core.PApplet;
import processing.core.PImage;

import java.awt.*;
import java.util.ArrayList;

public class GUI {

    PApplet p;
    Player player;
    ArrayList<FloatyText> textList;


    GUI(PApplet p, Player player, ArrayList<FloatyText> textList){
this.p = p;
this.player=player;
this.textList = textList;




    }



   void displayShop( ){
        if(player.buildMode)
            p.text("BUILD MODE",p.width/2,p.height-200);



            for (int i = 0; textList.size()>i;i++) {
                if(textList.get(i).moneyText()) {
                   textList.remove(i);
                    System.out.println("true");
                }
            }





       player.showMoney();
    }

    void displayDungeon() {

        player.showHealth();
        player.showStamina();

        p.fill(255);
        p.stroke(204, 102, 0);
        if (player.entrance == true) {
            this.p.fill(0, 255, 199);
            p.text("Want to go back to shop? Go through the portal(Interact with e on road).", p.width/2, p.height/2);
            //
            //p.text("Want to go back to shop? Go through the portal.", 740, 430);
        }
    }


}
