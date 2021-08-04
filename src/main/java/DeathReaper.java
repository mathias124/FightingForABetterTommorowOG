
import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public class DeathReaper {
PApplet p;
PVector position = new PVector();
Player player;
boolean  talkOpen = false;
boolean playerNearby;
Deathrealm deathrealm;
    ImageLoader imgLoad;

    int amount = 8;
    int count;

    float verticalRadius = 8;
    float horizontalRadius = 2.5f;
    float angle = 0;
    float xTotal;
    float yTotal;

DeathReaper(PApplet p,float posX,float posY, ImageLoader imgLoad) {
    this.p=p;
    this.position.x = posX;
    this.position.y = posY;
    this.imgLoad = imgLoad;

}
void drawDeathReaper() {
    p.background(imgLoad.deathRealm);
    p.fill(133);
    //p.rect(940,65,96,96);
    float rx = horizontalRadius*p.cos(angle);
    float ry = verticalRadius * p.sin(angle);
     xTotal = rx+940;
     yTotal = ry+65;

    p.image(imgLoad.grimReaper,xTotal,yTotal,96,96);
    angle+=0.05;

    if(talkOpen == true) {
        this.p.fill(0, 255, 199);
        this.p.text(" Accept fate?(interact with me)", 1055, 100);
    }else{
        p.fill(178);
        p.text("What is the Key to your suffering?", 1055, 65);

    //talkOpen = true;
    }
}

void ReaperPillars(){

    //p.rect();

}
void detectPlayer(Player player) {
    if(xTotal- 64.0f <= player.position.x + 96.0f && xTotal + 160.0f > player.position.x && yTotal - 20.0f <= player.position.y + 96.0f && yTotal + 160.f > player.position.y) {
        talkOpen = true;

    }else{
        talkOpen = false;

    }
}
}
