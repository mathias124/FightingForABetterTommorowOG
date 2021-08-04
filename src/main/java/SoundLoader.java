/*import processing.core.PApplet;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class SoundLoader {
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import javazoom.jl.player.PlayerApplet;
import processing.core.PApplet;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;



    public class SoundLoader extends Thread {
        File normalMusic;
        File bossMusic;
        File file;
        PApplet p;
        Player mp3;
        //Backgrounds backgrounds;

        SoundLoader(PApplet p,Location location) {
            this.p = p;
            this.location = location;
            normalMusic = new java.io.File("src\\main\\resources\\midgamefil.mp3");
            bossMusic = new java.io.File("src\\main\\resources\\bossfil.mp3");
        }

        public void run() {
            while(0<1){
                if(location.check){
                    back.check = false;
                    loadSounds();
                }

                playSounds();
            }}

        public void loadSounds() {
            if(!location.bossLevel)
                file = normalMusic;
            else
                file = bossMusic;
            try {
                BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(file));
                mp3 = new Player(buffer);

            } catch (Exception e) {
                //System.out.println(e);
            }
        }

        public void playSounds() {
            try {
                mp3.play(1);
            } catch (JavaLayerException e) {
                //System.out.println(e);
            }

        }

    }









}
*/