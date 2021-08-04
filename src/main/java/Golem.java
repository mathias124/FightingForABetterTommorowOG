import processing.core.PApplet;
import processing.core.PVector;

public class Golem extends Enemy {
    PApplet p;


    Golem(float xPos, float yPos, PVector playerPosition, PApplet p, Player player,ImageLoader imgLoad) {
        super(xPos, yPos, 0,200,350, playerPosition, p, player,imgLoad);
        //Orginal speed =2;
        img = imgLoad.cheeseGolem ;
        drop = Items.pizzaTopping;
    }




}
