import processing.core.PApplet;

import java.util.ArrayList;

import static processing.core.PConstants.CENTER;

public class Dungeon {

    PApplet p;

    ImageLoader imgLoad;
    Player player;
    Door portal;
    ArrayList<Enemy> enemies;
    Camera camera;
    int portalX = 70;
        int portalY = 100;
    int level;
    int DIAMETER = 80;
    int speed;
    Main m ;

    Dungeon(PApplet p,Player player,ArrayList<Enemy> enemies,Camera camera,ImageLoader imgLoad,Main m){

    this.p = p;
    this.player = player;
    this.enemies = enemies;
    this.camera = camera;
    this.imgLoad = imgLoad;
    this.m=m;
    portal= new Door(imgLoad.door);
    }

   void functions() {

        p.pushMatrix();

       cameraFunctions();
       p.image(imgLoad.mainMap,0,0);
       p.imageMode(CENTER);
       player.display();
       p.imageMode(0);
       playerFunctions();
       enemyFunctions();
       //System.out.println(portal.playerNearby(player,portalX,portalY,player.width,player.height,100,100));
       if(portal.playerNearby(player,portalX,portalY,player.width,player.height,1300,640)!=-1)
       if(player.activate)
           portal.function(m);
       player.activate= false;

       p.popMatrix();


   }
   void cameraFunctions(){
        camera.changeAngle();
   }

   void playerFunctions(){


       player.useStamina();
       player.entranceDetect();
       player.showAim(camera);





       p.mouseClicked();


       int bls = player.bullets.size();
       while (bls-- != 0) {
           player.bullets.get(bls).script();
           for(int i=0; i<enemies.size();i++)
            if (player.bullets.get(bls).hit(player.bullets, enemies.get(i))) {

                enemies.get(i).followingPlayer =true;
              
                player.bullets.remove(bls);
                break;
            }
       }


   }

   void enemyFunctions(){



       for (int i = 0; i < enemies.size(); i++) {
           enemies.get(i).update();
           enemies.get(i).display();
           if(enemies.get(i).health<0){
               switch(enemies.get(i).drop){

                   case pizzaTopping:{
                        player.inventory.add(new PizzaTopping(imgLoad.pizzatopping),1 );

                   }break;
                   case cheddar:{
                       player.inventory.add(new Cheddar(imgLoad.cheddar),1 );


                   }break;
                   case primadonna:{
                       player.inventory.add(new Primadonna(imgLoad.primadonna),1 );


                   }break;
                   case funnyfungus: {
                       player.inventory.add(new Funnyfungus(imgLoad.funnyfungus), 1);
                   }break;

               }
               enemies.remove(i);
i--;
           }
       }

   }


}
