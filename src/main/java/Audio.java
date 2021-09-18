
import jaco.mp3.player.MP3Player;
import processing.core.PApplet;

import java.io.File;

class Audio extends Thread {
    MP3Player mp3Player;
    MP3Player startmusic;
    MP3Player file;
    boolean Menumusic = false;
    Audio soundlocation;
    Location location;

    PApplet p;
//Audio(Location location){
    //  this.location = location;

// DER ER NOGET GALT MED LOCATION HER.
   Audio(PApplet p, Location location) {
        this.p = p;
        this.location = location;
        this.soundlocation = soundlocation;
       mp3Player = new MP3Player(new File("src\\main\\resources\\Darkrai's Theme Medley.mp3"));


    }

    public void run() {
if(location.check)
    try{
        mp3Player = new MP3Player(new File("src\\main\\resources\\Darkrai's Theme Medley.mp3"));
        //startmusic = new MP3Player(new File("src\\main\\resources\\PMD2 - In the Hands of Fate (Remastered).mp3"));

    }catch (Exception e){
        System.out.print(e);
    }

        }

        //while (0 < 1) {
          //  if (!location.check) {
            //    location.check = false;
              //  soundlocation(location);
            //}
            //playlocation();
        //}
    //}

      //      public void playlocation () {









    // audio = new Audio(p, location);
            //audio.start();
            //if (location.check = true) {
            //if (location.check == true) {

            //mp3Player.stop();
            //startmusic.play();



    }

