import processing.core.PApplet;
import processing.core.PFont;

public class FontLoader {

    PFont georgiaFont = new PFont();
PApplet p ;

    FontLoader(PApplet p){
        this.p = p;
    }

    void loadFont(){

        georgiaFont = p.loadFont("Georgia-20.vlw");

    }

}
