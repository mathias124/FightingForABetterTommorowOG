import processing.core.PApplet;
import processing.core.PVector;

public class ManagerEnemy extends  Enemy{


        PApplet p;


        ManagerEnemy(float xPos, float yPos, PVector playerPosition, PApplet p, Player player, ImageLoader imgLoad) {
            super(xPos, yPos, 4,100,600, playerPosition, p, player,imgLoad);
            //Orginal speed = 4;
            img = imgLoad.firkantmanager;
            drop = Items.clipboard;

        }
    }


