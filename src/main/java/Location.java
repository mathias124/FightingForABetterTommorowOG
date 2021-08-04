public class Location {

    Shop shop;
    Dungeon dungeon;
    GUI gUI;
    Deathrealm deathrealm;
    StartMenu startMenu;
    Info info;


    Location(Shop shop,Dungeon dungeon,GUI gUI,Deathrealm deathrealm,StartMenu startMenu,Info info){
    this.shop = shop;
    this.dungeon = dungeon;
    this.gUI = gUI;
    this.deathrealm = deathrealm;
    this.startMenu = startMenu;
    this.info = info;

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

            }break;

            case deathrealm:{
                deathrealm.deathrealmFunctions();

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


    }




}
