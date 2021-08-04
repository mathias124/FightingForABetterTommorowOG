import processing.core.PApplet;
import processing.core.PVector;


    public class Bummer extends Enemy {
        PApplet p;
        Enemy enemy;



        Bummer(float xPos, float yPos, PVector playerPosition, PApplet p, Player player, ImageLoader imgLoad) {
            super(xPos, yPos, 0,30,350, playerPosition, p, player,imgLoad);
            img = imgLoad.cheeseGolem ;
            drop = Items.pizzaTopping;
            if(enemy.enemyTalkRange == true);
            p.text("HVOR ER MIN TOPMADRAS",xPos,yPos);
            p.fill(255);

        }




    }


