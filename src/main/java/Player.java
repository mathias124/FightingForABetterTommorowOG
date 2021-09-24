
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;
import processing.core.PVector;

import java.awt.*;
import java.util.ArrayList;
import static processing.core.PConstants.*;

public class Player {

    PApplet p;

    ArrayList<Bullet> bullets;

    Inventory inventory;

    ImageLoader imgLoad;
    Audio audio;
    PVector position = new PVector();
    PVector velocity = new PVector();
    PVector bulletSpeed = new PVector();
    PVector runningSpeed = new PVector(1,1);

    FontLoader fontLoad;

    boolean mouseActivate;
    boolean isShooting = false;
    boolean showAim = false;
    boolean check = true;
    boolean down,up,left,right = false;
    boolean ready = true;
    boolean running = false;
    boolean notAbleToRun = false;
    boolean buildMode = false;
    boolean activate = false;
    boolean immobile = false;
    boolean inventoryOpen = false;
    boolean dead = false;
    boolean entrance = false;
    boolean infoScreen = false;

    float maximumHealth = 100;
    float healthbarWidth = 200;
    float healthbarHeight = 40;
    float playerHealth = 100;
    float maximumStamina = 100;
    float staminaLoss = 0.5f;
    float passiveStamina = 0.8f;
    float stamina = maximumStamina;

    int width = 63;
    int height = 63;
    int money = 100;
    int healthpot = 1;
    int wingedsword = 1;



    Player(PApplet p, ArrayList<Bullet> bullets,Inventory inventory,ImageLoader imgLoad,FontLoader fontLoad,Audio audio) {
        this.playerHealth = playerHealth;
        this.p = p;
        this.bullets = bullets;
        this.imgLoad = imgLoad;
        this.inventory = inventory;
        this.fontLoad = fontLoad;
        this.audio = audio;
        position.set(1400, this.p.height / 2);

    }


    void changePosition(ArrayList<GridSpaceDefault> grid,Location location) {

        PVector speed = new PVector(velocity.x, velocity.y);
        speed.mult(runningSpeed.x);

        PVector temp = new PVector(position.x,position.y);
        temp.add(speed);

        boolean add = true;
        if(location.location == LocationType.shop){

        for (int i =0;i<grid.size();i++) {
            if (grid.get(i).furnitureGridType == FurnitureTypes.wall) {
                if (grid.get(i).furniture.collision(this, temp.x, temp.y, grid.get(i).x, grid.get(i).y, grid.get(i).width, grid.get(i).height))
                add = false;
            }
        }}
        if (add == true)
            position.add(speed);



        // Currently constrain for DeathRealm and Dungeon and shop.
        // Se efter dead text
        if (location.location == LocationType.dungeon) {
            position.x = p.constrain(position.x, 372, 4200);
            position.y = p.constrain(position.y, 340, 4247);
        }
        else {
        position.x = p.constrain(position.x, 50, p.width - width - 10);
        position.y = p.constrain(position.y, 0, p.height - height - 10);
    }
    }
    void entranceDetect() {
            //if(20- 64.0f <= position.x + 96.0f && 20 + 160.0f > position.x && 60 - 20.0f <= position.y + 96.0f && 60 + 160.f > position.y) {
                if(740- 64.0f <= position.x + 96.0f && 740 + 380.0f > position.x && 60 - 740.0f <= position.y + 96.0f && 60 + 380.f > position.y) {
                entrance = true;
//
            }else{
                entrance = false;

            }
        }


   void showAim(Camera camera) {

        if (showAim) {
           p.stroke(255, 0, 0, 180);
           p.strokeWeight(3);
           p.line(p.mouseX-camera.translateX, p.mouseY-camera.translateY, position.x, position.y);

           p.stroke(0);


       }
   }
    void draw(ArrayList<GridSpaceInventory> inventoryGridList,ArrayList<GridSpaceDefault> grid,Location location) {
        //void draw(location) {
        runAbility();
        regainStamina();
        changePosition(grid,location);


        if(location.location != LocationType.menu&&location.location !=LocationType.info)
        inventory.display(buildMode,this,inventoryGridList);

        if (playerHealth < 0) {
            playerHealth = 0;
            dead = true;
            //position.set(960, 890);
            location.changeLocation(LocationType.deathrealm);

            position.set(960, 890);


        }
    }
    void display() {

        //p.rect(position.x, position.y, playerWidth, playerHeight);

        // Se på if(multiple booleans display picture. fx if (down && up) så display kun det her.
        //   p.println(velocity);


        String s = Integer.toString((int) velocity.x) + Integer.toString((int) velocity.y);
//System.out.println(s);
        switch (s) {

            case "-1-1": {
//Skrot til venstreopad.


                //System.out.println("SkrotvenstreOpad");
                if(running)
                    p.image(imgLoad.leftUpImgs[p.frameCount/8 %2],position.x,position.y,width,height);
                else
                    p.image(imgLoad.leftUpImgs[p.frameCount/18 %2],position.x,position.y,width,height);


            }
            break;

            case "-10": {
                //Venstre.
//
                //System.out.println("Venstre");
                if(running)
                    p.image(imgLoad.runningleft,position.x,position.y,width,height);

            else
                    p.image(imgLoad.leftsideplayer,position.x,position.y,width,height);
            }
            break;
            case "10": {
//Højre
                //System.out.println("1+0");
                //System.out.println("højre");
                if(running)
                    p.image(imgLoad.runningright,position.x,position.y,width,height);
                else
                p.image(imgLoad.rightsideplayer,position.x,position.y,width,height);

            }
            break;
            case "11": {

                // System.out.println("1+1");
                if(running)
                    p.image(imgLoad.downRightImgs[p.frameCount/8 %2],position.x,position.y,width,height);
                else
                    p.image(imgLoad.downRightImgs[p.frameCount/18 %2],position.x,position.y,width,height);
                //System.out.println("skrotnedadhøjre");

            }
            break;

            case "0-1": {
//Opad
                //System.out.println("0-1");
             //   System.out.println("Opad");
                if(running)
                    p.image(imgLoad.behindImgs[p.frameCount/8 %2],position.x,position.y,width,height);
                else
                    p.image(imgLoad.behindImgs[p.frameCount/18 %2],position.x,position.y,width,height);
            }
            break;
            case "01": {
//nedad,
                //  System.out.println("0+1");
                if(running)
                    p.image(imgLoad.frontImgs[p.frameCount/8 %2], position.x, position.y, width, height);
                else
                    p.image(imgLoad.frontImgs[p.frameCount/18 %2], position.x, position.y, width, height);

               // System.out.println("nedad");

            }
            break;
            case "-11": {
                //Skrot Venstre nedad.
                if(running)
                    p.image(imgLoad.downLeftImgs[p.frameCount/8 %2],position.x,position.y,width,height);
                else
                    p.image(imgLoad.downLeftImgs[p.frameCount/18 %2],position.x,position.y,width,height);


                //System.out.println("-11");
              //  System.out.println("Skrotvenstrenedad");

            }
            break;

            case "1-1": {
                //Skrot Venstre opad.
                if(running)
                    p.image(imgLoad.rightUpImgs[p.frameCount/8 %2],position.x,position.y,width,height);
                else
                    p.image(imgLoad.rightUpImgs[p.frameCount/18 %2],position.x,position.y,width,height);

                //System.out.println("-11");
             //   System.out.println("Skrothøjreopad");

            }
            break;
            case "00": {
                //Skrot Venstre nedad.


             //   System.out.println("stille");
                p.image(imgLoad.forward1,position.x,position.y,width,height);
            }
            break;

        }
        p.imageMode(0);

    }
     void addBullet(Camera camera) {
        bulletSpeed.set(p.mouseX-camera.translateX,p.mouseY-camera.translateY,0);
        bulletSpeed.sub(position);
        bulletSpeed.normalize();
        bulletSpeed.mult(Bullet.VEL);
        Magasine();

    }
    void Magasine() {
            bullets.add(new Bullet(p,position, bulletSpeed,imgLoad));
        }

    void gameoverscreen(boolean gameoverscreen) {
        if(dead ==true) {

            // Just for right now.

        }
    }

    void showHealth() {
        if (playerHealth < 50) {
            p.fill(175, 215, 0);
        }
        else if ( playerHealth > 50) {
            p.fill(0,255,0);
        }
        else if ( playerHealth < 25) {
            p.fill(0,255,0);
        }

        float calculateplayerHP = (playerHealth / maximumHealth)* healthbarWidth;

        //der er 2 rect tilstede grundet til at der skal være en omkreds om cirkel (da det andet areal/længde går nedad når den mister liv).


        p.stroke(204, 104, 0);


        p.strokeWeight(3);

        p.rect(1660,25,calculateplayerHP,healthbarHeight);
        p.noFill();
        p.rect(1660,25,healthbarWidth,healthbarHeight);
        //Til at vise den maximale HP bar stadig selvom HP forsvinder.

        p.fill(255);
        p.pushMatrix();
        p.text((int)calculateplayerHP/2+" HP",1725,50);
        p.popMatrix();
    }
 void useStamina() {
     if (running == true) {
         stamina -= staminaLoss;
         if (stamina < 0) {
             stamina = 0.f;

             if (stamina < 10) {
                 notAbleToRun = true;
                 if (notAbleToRun) {
                     running = false;
                 }
             }
         }
     }
 }
void regainStamina() {
    if (running == false) {
        stamina += passiveStamina;
        if (stamina > maximumStamina) {
            stamina = 100.f;
        }
    }
}

void showTopIcon(){
        p.fill(255);
        p.text(money  +" $",20,20);
        p.image(imgLoad.healthpot,40,40);
        p.text(healthpot + "",40,40);
        p.image(imgLoad.wingedsword,85,35);

        p.text(wingedsword+"",85,45);


}

   void showStamina(){
   p.fill(244,35,3);
   p.noStroke();
   float displaystamina = stamina *2;
   p.rect(1660,75,displaystamina,40);


   p.stroke(0);

   p.fill(255);
   p.text((int)stamina+" S",1725,110);
   }

    void runAbility(){
    //PVector runningspeed = new PVector();

if(running == false) {
    runningSpeed.set(1,1);
}
else{
    runningSpeed.set(4,4);


    }
    }
    void interact(){

    }
    void controls(char key, int keyCode,  boolean pressed,LocationType location,Camera camera) {
        velocity.set(0, 0);


        if (key != p.CODED)
            switch (key) {

                case '1': {
                    if (pressed == true) {
                        if (inventory.useBarList.get(0).useList.size() > 0)
                        inventory.useBarList.get(0).selected = !inventory.useBarList.get(0).selected;
                        for (int i = 0; i < 5; i++) {
                            if (i != 0)
                                inventory.useBarList.get(i).selected = false;
                        }
                        if (inventory.useBarList.get(0).selected)
                            inventory.selected = inventory.useBarList.get(0);
                    }

                }
                break;
                case '2': {
                    if (pressed == true) {
                        if (inventory.useBarList.get(0).useList.size() > 1)
                        inventory.useBarList.get(1).selected = !inventory.useBarList.get(1).selected;
                        for (int i = 0; i < 5; i++) {
                            if (i != 1)
                                inventory.useBarList.get(i).selected = false;
                        }
                        if (inventory.useBarList.get(1).selected)
                            inventory.selected = inventory.useBarList.get(1);
                    }

                }
                break;
                case '3': {
                    if (pressed == true) {
                        if (inventory.useBarList.get(0).useList.size() > 2)
                            inventory.useBarList.get(2).selected = !inventory.useBarList.get(2).selected;
                        for (int i = 0; i < 5; i++) {
                            if (i != 2)
                                inventory.useBarList.get(i).selected = false;
                        }
                        if (inventory.useBarList.get(2).selected)
                            inventory.selected = inventory.useBarList.get(2);
                    }

                }
                break;
                case '4': {
                    if (pressed == true) {
                        if (inventory.useBarList.get(0).useList.size() > 3)
                            inventory.useBarList.get(3).selected = !inventory.useBarList.get(3).selected;
                        for (int i = 0; i < 5; i++) {
                            if (i != 3)
                                inventory.useBarList.get(i).selected = false;
                        }
                        if (inventory.useBarList.get(3).selected)
                            inventory.selected = inventory.useBarList.get(3);
                    }


                }
                break;
                case '5': {
                    if (pressed == true) {
                        if (inventory.useBarList.get(0).useList.size() > 4)
                            inventory.useBarList.get(4).selected = !inventory.useBarList.get(4).selected;
                        for (int i = 0; i < 5; i++) {
                            if (i != 4)
                                inventory.useBarList.get(i).selected = false;
                        }
                        if (inventory.useBarList.get(4).selected)
                            inventory.selected = inventory.useBarList.get(4);
                    }
                }
                break;

                case 'o':
                case 'O':{
                    if(pressed && check){
                        if(!inventoryOpen)
                        inventory.open(this);
                        else
                            inventory.close(this);
                        check = false;
                    }else{
                        check = true;
                    }



                }   break;

/*
                case 'l':
                case 'L': {
                    if (pressed) {
                        inventory.add(new PizzaTopping(imgLoad.pizzatopping), 5);
                        inventory.add(new Cheddar(imgLoad.cheddar),5);
                        inventory.add(new Primadonna(imgLoad.primadonna),5);
                 //       System.out.println(inventory.itemList);
                    }

                }


                break;
*/
                case 'E':
                case 'e':{
                    if(pressed == true)
                    activate=true;

                }break;


                case 'F':
                case 'f': {
                    if ((pressed == true) )
                        showAim = !showAim;



            }break;
                case 'S':
                case 's': {
                    if((pressed) &&(ready))
                        down=true;
                    else{
                        down=false;}

                }break;
                case 'W':
                case 'w': {
                    if((pressed) &&(ready))
                        up = true;
                    else
                        up=false;

                }break;
                case 'A':
                case 'a': {
                    if((pressed) &&(ready))
                        left=true;
                    else
                        left=false;

                }break;
                case 'k':
                case 'K' :{
                    if (pressed)
                        camera.mode = (camera.mode + 1) % 2;

                    }break;



                case 'D':
                case 'd': {
                    if((pressed) &&(ready))
                        right=true;

                    else
                        right=false;



                }break;

                case TAB:{
                    if(pressed) {
                        for(int i=0;i <inventory.useBarList.size();i++)
                        inventory.useBarList.get(i).selected = false;

                        if (location == LocationType.shop) {
                            buildMode = !buildMode;

                        }

                    }

                }break;





            }
        else{
            switch (keyCode){

                case DOWN: {
                    if((pressed) &&(ready))
                        down=true;
                    else{
                        down=false;}

                }break;

                case UP: {
                    if((pressed) &&(ready))
                        up=true;
                    else{
                        up=false;}

                }break;
                case RIGHT: {
                    if((pressed) &&(ready))
                        right=true;
                    else{
                        right=false;}


                }break;
                case LEFT: {
                    if((pressed) &&(ready))
                        left=true;
                    else{
                        left=false;}


                }break;
                case SHIFT: {
                    if((pressed)) {
                        if (ready)
                            running = true;
                    }
                    else {
                        running = false;


                    }

                }break;



            }


        }
        velocity.set((((right)?1:0) +((left)?-1:0)),(((up)?-1:0) +((down)?1:0)));

        }


     void mouseControls(int mouseX, int mouseY,boolean pressed,LocationType location,ArrayList<GridSpaceDefault> grid,ArrayList<GridSpaceInventory> gridInventory,Camera camera) {
        if(location==LocationType.dungeon) {
            if(pressed)
               if(check) {
                check=false;

                   addBullet(camera);
               }
            else {
                check=true;
                isShooting =false;
            }
        }

         if(location == LocationType.shop) {
             if (pressed) {
                 for (int i = 0; i < grid.size(); i++)
                     grid.get(i).pressed(mouseX, mouseY);
                 for (int i = 0; i < gridInventory.size(); i++)
                     gridInventory.get(i).pressed(mouseX, mouseY);
             }
             inventory.selector(true, mouseX, mouseY, inventory);
         }

         if(location == LocationType.menu||location == LocationType.info) {

             if(pressed)
                 mouseActivate = true;

         }


     }

}
