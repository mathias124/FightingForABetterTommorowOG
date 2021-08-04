import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public class ToolBar {

    PApplet p;

    PVector position;


    ArrayList<Item> useList = new ArrayList<>();
    int width = 100;
    int height = 100;
    int toolBarCount;
    boolean build;
    boolean selected = false;
    ToolBar(ArrayList<Item> list, int toolBarCount, PApplet p){
        this.p =p;
        this.toolBarCount = toolBarCount;

        this.position = new PVector((p.width / 2) - 300+((1+toolBarCount)*100),p.height - 101);
        useList = list;

    }


    void displayToolBar(){

        p.strokeWeight(5);
        if(selected) {

            p.stroke(0, 255, 0);
        }else p.stroke(0,0,0);
        p.noFill();

        if (useList.size()-1 < toolBarCount)
            p.fill(255, 255, 255);
        p.rect(position.x, position.y, width, height);

            p.stroke(0);
            p.strokeWeight(0);

        if(useList.size() >toolBarCount) {
            p.image(useList.get(toolBarCount).getImg(), position.x, p.height - 101);

        }


    }



}
