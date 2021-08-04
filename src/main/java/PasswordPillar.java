import processing.core.PApplet;
import processing.core.PVector;

public class PasswordPillar {
    int amount;
    float x;
    float y;

    float diameter = 20;
    PVector playerPosition;
    Player player;

    PApplet p;

    int[][] gridData = new int[3][2];

    float pillarWidth = 64;
    float pillarHeight = 64;

//PasswordPillar(PApplet p, int xOffsetTemp, int yOffsetTemp,int xTemp, int yTemp,int tempAmount) {
//PasswordPillar(PApplet p,int xTemp, int yTemp,int tempAmount) {

    PasswordPillar(float xPos, float yPos, int pillarDiameter, PVector position, Player player, PApplet p) {
        this.playerPosition = playerPosition;
        this.player = player;
        x = xPos;
        y = yPos;
        this.p = p;

    }

    void Objectdata() {

    }

    void display() {
        //Skulle være et Password Pillar.

        //p.fill(135);
        //for (int i = 1; i < 8; i++) {
        //gridData[1][1] = 1;

        //for (int xTemp = 0; xTemp < 3; xTemp++) {
        //for (int yTemp = 0; yTemp < 2; yTemp++) {

        // if (gridData[xTemp][yTemp] == 1);
        // p.fill(255, 2, 2);
        //  p.rect(y+xTemp * 15, x+yTemp * 15, pillarWidth, pillarHeight);

        //}
        // }

    }
}