import processing.core.PApplet;
import processing.core.PVector;

public class CheeseGhast extends Enemy {


    CheeseGhast(float xPos, float yPos, PVector playerPosition, PApplet p, Player player,ImageLoader imgLoad) {
        super(xPos, yPos, 0,50,900, playerPosition, p, player,imgLoad);

        //Orginal Speed = 6.
        img = imgLoad.cheeseGhastImgs[0] ;
        drop = Items.primadonna;
    }


}
