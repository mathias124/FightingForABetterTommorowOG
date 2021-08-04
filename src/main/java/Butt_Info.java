import processing.core.PApplet;

public class Butt_Info extends Button  {
    Main m;

    Butt_Info(PApplet p, Player player,Main m){
        super( p, player);
        position.set(p.width/2,500);
        text = "Info";
        this.m = m;
    }

    void function(){
        m.location.location= LocationType.info;



    }



}
