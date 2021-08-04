import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;

public class StartMenu {

    ArrayList<Button> buttons = new ArrayList<>();
    Player player;
    PApplet p ;
    PImage startUp;
    StartMenu(PApplet p, Player player, Main m, PImage startUp){
        this.p = p;
        this.player = player;
        this.startUp = startUp;
        buttons.add(new Butt_LocationChange(p,player,m,LocationType.shop,"Start",p.width/2,400));
        buttons.add(new Butt_Info(p,player,m));
        buttons.add(new Butt_Quit(p,player));

    }



    void functions(){
        p.background(startUp);
        for(int i =0;i<buttons.size();i++){
            buttons.get(i).checkPressed();
            buttons.get(i).display();




        }
        player.mouseActivate = false;




    }

}
