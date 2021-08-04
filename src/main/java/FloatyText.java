import processing.core.PApplet;

public class FloatyText {
PApplet p;
    int amount; float x; float y;
    float  baseY;

FloatyText(PApplet p,int amount, float x, float y){

    this.p = p;
this.amount = amount;
this.x = x;
this.y = y;
    baseY=y;

}


    boolean moneyText(){
    boolean result = false;
if(amount != 0)
            p.fill(0, 122, 0);
else
    p.fill(122,0,0);

        p.text(amount + " $", x+35, y);
            y -= 1;
            p.fill(255, 255, 255);

if(y<baseY-100)
result = true;

return result;
    }

}
