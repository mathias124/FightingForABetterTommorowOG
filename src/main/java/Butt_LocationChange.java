import processing.core.PApplet;

public class Butt_LocationChange extends Button  {

    Main m;
    LocationType location;
    Butt_LocationChange(PApplet p, Player player, Main m,LocationType location,String txt,int x,int y){
        super( p, player);
        position.set(x,y);
        text = txt;
        this.m = m;
        this.location= location;

    }

    @Override
    void function() {


        m.location.location = location;
    }
}
