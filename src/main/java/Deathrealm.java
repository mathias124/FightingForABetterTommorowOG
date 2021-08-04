import processing.core.PApplet;

import java.util.ArrayList;

import static processing.core.PConstants.CENTER;


public class Deathrealm {
    PApplet p;
    Door reaper;
    Player player;
    DeathReaper deathReaper;
    ArrayList<PasswordPillar> pillars;
    Main m;

    int unit = 40;
    int count;

    int level;
    int DIAMETER = 80;
    int hastighed = 4;
    int pillardiameter = 20;
    float longlarg = 15;
    int [] [] gridData = new int [3] [2];
    int reaperX ;
    int reaperY=100;

    int xTemp;
    int yTemp;
    Deathrealm(PApplet p, Player player, ArrayList<PasswordPillar> pillars, DeathReaper deathReaper,Main m) {
        this.m =m;
        this.p = p;
        this.player = player;
        this.deathReaper = deathReaper;
        this.pillars = pillars;
        reaperX = p.width/2;
        reaper = new Door(null);
    }

    void deathrealmFunctions() {
        playerFunctions();

        deathReaperFunctions();
        if(player.activate&&reaper.playerNearby(player,reaperX,reaperY,player.width,player.height,100,100)!=-1)
            reaper.function(m);
        player.activate = false;
        //passwordPillarFunctions();
        //passwordLoop();


    }

    void playerFunctions() {



    }

    void deathReaperFunctions() {
        deathReaper.drawDeathReaper();
        deathReaper.ReaperPillars();
        deathReaper.detectPlayer(player);
        p.imageMode(CENTER);
        player.display();
        p.imageMode(0);




        // Tilføj Circulation effect?


    }
void passwordLoop() {
    gridData[1][1] = 1;
    for (int xTemp = 0; xTemp < 3; xTemp++) {
        for (int yTemp = 0; yTemp < 2; yTemp++) {
            if(gridData[xTemp][yTemp]==1)
                p.rect(xTemp*15,yTemp*15,15,15);

        }
    }
}
    void passwordPillarFunctions() {
       /*
        int xTemp = 0;
        int yTemp = 0;
        for (yTemp = 0; yTemp < 3; yTemp++) {
            for (xTemp = 0; xTemp < 2; xTemp++) {
                gridData[yTemp][xTemp] = 0;
            }
            gridData[1][1]=1;
        }
*/


        if (pillars.size() < 6)

            //pillars.add(new PasswordPillar((int) yTemp, (int) xTemp, pillardiameter, player.position, player, p));
        pillars.add(new PasswordPillar(xTemp, yTemp, pillardiameter, player.position, player, p));

              //pillars.add(new PasswordPillar((int) p.random(0, 1000), (int) p.random(0, 1000), pillardiameter, player.position, player, p));

        for (int j = 0; j < pillars.size(); j++) {
            pillars.get(j).display();
        }
    }
    }


