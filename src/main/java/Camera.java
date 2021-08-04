import processing.core.PApplet;
import processing.core.PVector;

import static processing.core.PConstants.CODED;
import static processing.core.PConstants.CONTROL;

public class Camera {

    Player player;
    PVector perspective = new PVector();
    int mode;
    PVector startpos = new PVector(250,250);
    PApplet p;
    PVector position;
    float translateX;
    float translateY;
    boolean ready;

    public Camera( PApplet p, PVector position,Player player) {
        this.p = p;
        this.position = position;
        this.player = player;

    }

    void changeAngle() {
        switch (mode) {
            case 0: {
                translateX = 0;
                translateY = 0;
            }
            break;
            case 1: {
                translateX = p.width / 2 - player.position.x-player.width/2;
                translateY = p.height / 2 - player.position.y-player.height/2;
                //  p.translate(p.width / 2, p.height / 2);
                //  p.translate(-perspective.x, -perspective.y);


            }
            break;

        }
        p.translate(translateX, translateY);

    }
    }

