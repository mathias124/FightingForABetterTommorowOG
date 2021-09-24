import processing.core.PApplet;
import processing.core.PVector;

public class TriangelSoldier extends  Enemy {


    PApplet p;
    float x;
    float y;
    //boolean passiveWalk;

    TriangelSoldier(float xPos, float yPos, PVector playerPosition, PApplet p, Player player, ImageLoader imgLoad) {
        super(xPos, yPos, 4, 100, 350, playerPosition, p, player, imgLoad);
        //Orginal speed = 4;
        img = imgLoad.trekantsoldat;
        drop = Items.mp5;
        //passiveWalk = true;
    }
}