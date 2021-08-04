import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;
import java.util.ArrayList;

public class Bullet {

 PApplet p;

 PVector bulletLocation;
 PVector pos = new PVector();
 PVector bulletSpeed = new PVector();
 PImage skud;
 ImageLoader imgLoad;

    static final short FREQUENCY=2;
    static final short VEL = 5;

    int bullettype;
    int bulletDiameter =17;

    //boolean isShooting;


    Bullet(PApplet p, PVector bulletLocation, PVector velocity,ImageLoader imgLoad) {
        this.p = p;
        this.imgLoad = imgLoad;
        this.bulletLocation = bulletLocation;
        bullettarget(bulletLocation,velocity);
    }

    void bullettarget(PVector bulletlocation, PVector velocity) {
        pos.set(bulletlocation);
        bulletSpeed.set(velocity);
        //isShooting = false;
    }

void drawbullet() {

         p.fill(250,150,150);
       // p.ellipse(pos.x,pos.y,bulletDiameter,bulletDiameter);
        p.image(imgLoad.skud,pos.x,pos.y,bulletDiameter,bulletDiameter);



}
void movebullet() {

    pos.add(bulletSpeed);

}
boolean check() {
        return pos.x > p.width | pos.x < 0 | pos.y > p.height | pos.y < 0;
}

    boolean hit(ArrayList<Bullet> bullets, Enemy enemy) {
        if(((pos.x <= enemy.enemyPosition.x+ enemy.enemyDiameter && pos.x >= enemy.enemyPosition.x) ||(pos.x+bulletDiameter <= enemy.enemyPosition.x+ enemy.enemyDiameter && pos.x+bulletDiameter >= enemy.enemyPosition.x)) && (((pos.y <= enemy.enemyPosition.y+ enemy.enemyDiameter && pos.y >= enemy.enemyPosition.y))|| (pos.y+ bulletDiameter <= enemy.enemyPosition.y+ enemy.enemyDiameter && pos.y+bulletDiameter >= enemy.enemyPosition.y))) {
            int hitdamage = (int) p.random(10,21);

            enemy.health -= hitdamage;
            enemy.knockback=true;
            return true;
        }
return false;
    }
void script() {


        drawbullet();
        movebullet();

        //hit();
        //return isShooting;

}



}
