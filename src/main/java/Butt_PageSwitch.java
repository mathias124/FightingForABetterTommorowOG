import processing.core.PApplet;

public class Butt_PageSwitch extends Button {

    Info info;
    int mulitiplier;
    Butt_PageSwitch(PApplet p, Player player,String txt,Info info,int x,int y,int multiplier) {
        super(p, player);
        position.set(x,y);
        text = txt;
        this.info = info;
        this.mulitiplier = multiplier;

    }

    @Override
    void function() {
        info.count+= mulitiplier;
    }
}
