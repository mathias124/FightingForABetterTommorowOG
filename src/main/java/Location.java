import jaco.mp3.player.MP3Player;

import java.io.File;

public class Location {

    Shop shop;
    Dungeon dungeon;
    GUI gUI;
    Deathrealm deathrealm;
    StartMenu startMenu;
    Info info;
    Audio soundlocation;
    boolean check = false;

    Location(Shop shop,Dungeon dungeon,GUI gUI,Deathrealm deathrealm,StartMenu startMenu,Info info,Audio soundlocation){
    this.shop = shop;
    this.dungeon = dungeon;
    this.gUI = gUI;
    this.deathrealm = deathrealm;
    this.startMenu = startMenu;
    this.info = info;
    this.soundlocation = soundlocation;


    }


    LocationType location = LocationType.menu;


    void functions(Main m){

        switch (location) {

            case shop: {

                shop.shopFunction(m,m);
                gUI.displayShop();


            }
            break;

            case dungeon:{
                dungeon.functions();
                gUI.displayDungeon();
                check=true;


            }break;

            case deathrealm:{
                deathrealm.deathrealmFunctions();
            check=false;

            }
           break;

            case menu:{

                startMenu.functions();

            }break;

            case info:{
                info.functions();

            }break;


            }
        }





    void changeLocation(LocationType location){

        this.location = location;
        changeMusic(soundlocation);


    }
    void changeMusic(Audio soundlocation){
        soundlocation.mp3Player = new MP3Player(new File("src\\main\\resources\\Darkrai's Theme Medley.mp3"));
        }
    }




