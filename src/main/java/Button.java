import processing.core.PApplet;
import processing.core.PVector;

import javax.swing.text.Position;

public class Button  {

    PVector position = new PVector();

    Player player;

    PApplet p;
    
    String text;



    int width = 200;
    int height = 50;

    Button(PApplet p,Player player){
        this.p = p;
        this.player = player;

    }

    void function(){

        System.out.println(text);

    }

    void checkPressed(){
        if(player.mouseActivate&&(p.mouseX>position.x-width/2&&p.mouseX<position.x+width/2&&p.mouseY>position.y-height/2&&p.mouseY<position.y+height/2))
        function();
//Mousecontrols bliver ikke kørt
    }

    void display(){
        p.rectMode(3);
        p.fill(255);
        p.rect(position.x,position.y,width,height);
        p.fill(0);
        p.textAlign(3);
        p.text(text,position.x,position.y);
        p.rectMode(0);
        p.textAlign(0);


    }



}
