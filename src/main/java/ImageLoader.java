import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;

public class ImageLoader {
    //Backgrounds
    PImage shopBackground;
    PImage startUp;
    PImage cavebackground;
    PImage mainMap;


    //Animations.
    ArrayList<PImage> tutorial = new ArrayList<>();

    PImage[] frontImgs = new PImage[2];
    PImage[] behindImgs = new PImage[2];
    PImage[] rightUpImgs = new PImage[2];
    PImage[] leftUpImgs = new PImage[2];
    PImage[] downRightImgs = new PImage[2];
    PImage[] downLeftImgs = new PImage[2];
    PImage[] cheeseGhastImgs = new PImage[2];


    //items  models.
    PApplet p;
    PImage parmesan;
    PImage cheddar;
    PImage primadonna;
    PImage pizzatopping;
    PImage funnyfungus;
    PImage skud;
    PImage deathItem;
    PImage clipboard;
    PImage healthpot;

    //Player models
    PImage npcmale;
    PImage captaincheese;
    PImage enemy;
    PImage cheeseGolem;
    PImage cheeseDemon;
    PImage grimReaper;
    PImage uzzi;
    PImage bummer;

    PImage firkantmanager;



    //only player

    PImage leftsideplayer;
    PImage rightsideplayer;
    PImage forward1;
    PImage runningright;
    PImage runningleft;
    PImage rightup;




    //Furniture

    PImage wall;
    PImage door;
    PImage shopCounter;
    PImage cashRegister;
    PImage pillar;
    PImage deathRealm;

    PImage floor;



    float scaleW = 1;
    float scaleH = 1;

    ImageLoader(PApplet p) {
        this.p = p;
    }


    void loadTheImages() {

/// Hvis resize(skulle importeres).
        //scaleH = (float) w/1920;
        //scaleW = (float) h/1080;

//Structure
        wall = p.loadImage("wall.png");
        door = p.loadImage("door.png");
        floor = p.loadImage("floor.png");
        shopCounter = p.loadImage("shopCounter.png");
        cashRegister = p.loadImage("CashRegister.png");
        pillar = p.loadImage("Pillar.png");
        deathRealm = p.loadImage("deathrealm.png");



        //Loaditemsmodel
        pizzatopping = p.loadImage("pizza topping.png");
        cheddar = p.loadImage("cheddar.png");
        primadonna = p.loadImage("Primadonna-export.png");
        funnyfungus = p.loadImage("funnyfungus.png");
        skud = p.loadImage("skud.png");
        deathItem = p.loadImage("deathitem.png");
        clipboard = p.loadImage("clipboard.png");
        healthpot = p.loadImage("healthpot.png");


        //Characters & Mobs
        firkantmanager = p.loadImage("firkantmanager.png");
        captaincheese = p.loadImage("Kaptajn Ost.png");
        cheeseGolem = p.loadImage("cheesemob.png");
        cheeseDemon = p.loadImage("cheesedemon.png");
        uzzi = p.loadImage("uzzinew.png");
        //Backgrounds
        startUp = p.loadImage("startscreen-export.png");
        cavebackground = p.loadImage("Caveground.png");
        shopBackground = p.loadImage("shopbackgrounden.png");
        mainMap = p.loadImage("MainMapground.png");
        bummer = p.loadImage("Bummer.png");


//Player
        runningright = p.loadImage("runningright.png");
        runningleft = p.loadImage("runningleft.png");

        leftsideplayer = p.loadImage("leftsidecheeseman.png");
        rightsideplayer = p.loadImage("rightsidecheeseman.png");
        //rightup = p.loadImage("rightup1.png");

        //Model 3/4 perspective playermodels.
        grimReaper = p.loadImage("GrimR.png");
        forward1 = p.loadImage("forwardplayer1.png");

        for (int i = 1; i <= 2; i++) {
            frontImgs[i-1] = p.loadImage("forwardplayer"+i+".png");
            behindImgs[i-1] = p.loadImage("behindcheeseman"+i+".png");
            rightUpImgs[i-1] = p.loadImage("rightup"+i+".png");
            leftUpImgs[i-1] = p.loadImage("leftup"+i+".png");
            downRightImgs[i-1] = p.loadImage("downright"+i+".png");
            downLeftImgs[i-1] = p.loadImage("downleft"+i+".png");
            cheeseGhastImgs[i-1] = p.loadImage("cheeseghast"+i+".png");
        }

        for(int i = 1; i<=4;i++){
            tutorial.add(new PImage());
        tutorial.set(i-1,p.loadImage(i+".png"));


        }

    }
}
