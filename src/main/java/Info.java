import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;



public class Info {
    int count =0;
    ArrayList<PImage> tutorial = new ArrayList<>();
    ArrayList<Button> buttons = new ArrayList<>();
    Main m;
    PApplet p;
    Info(PApplet p,Main m,ArrayList<PImage> tutorial){
        this.tutorial = tutorial;
        this.m = m;
        this.p = p;
        buttons.add(new Butt_LocationChange(p,m.player,m,LocationType.menu,"Back to menu",p.width/2,p.height-100));
        buttons.add(new Butt_PageSwitch(p,m.player,"Back",this,200,p.height-100,-1));
        buttons.add(new Butt_PageSwitch(p,m.player,"Forward",this,p.width-200,p.height-100,1));


    }


void functions(){

display();
    for(int i =0;i<buttons.size();i++){

        buttons.get(i).checkPressed();
        buttons.get(i).display();




    }
    m.player.mouseActivate = false;


}


void display(){
        if(count<0)
            count = 0;
        if (count > tutorial.size()-1)
            count= tutorial.size()-1;
        p.background(tutorial.get(count));

}

}
