import processing.core.PApplet;
import processing.core.PVector;

public class Uzzi extends Enemy{
    PApplet p;


    Uzzi(float xPos, float yPos, PVector playerPosition, PApplet p, Player player, ImageLoader imgLoad) {
        super(xPos, yPos, 0,150,650, playerPosition, p, player,imgLoad);
        //Orginal Speed 3.5f
        img = imgLoad.uzzi;
        drop = Items.funnyfungus;
    }




}


