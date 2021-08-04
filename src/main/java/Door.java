import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Door extends Furniture {


Door(PImage img){
    this.img= img;


}

@Override
    void function(Main m) {
        m.player.buildMode = false;
        if(m.location.location == LocationType.shop) {
            m.location.location = LocationType.dungeon;
            m.player.position.x = 750;
            m.player.position.y=370;
            m.camera.mode = 1;
            m.enemies.clear();
            for(int i =0; i<20;i++){
            PVector getRandomSpawn = getRandomSpawn(m.player.p);
            m.enemies.add(new Golem(getRandomSpawn.x, getRandomSpawn.y,  m.player.position, m.player.p, m.player,m.imgLoad));
            }
            for(int i =0; i<10;i++) {
                PVector getRandomSpawn = getRandomSpawn(m.player.p);

                m.enemies.add(new CheeseDemon((int) getRandomSpawn.x, (int) getRandomSpawn.y, m.player.position, m.player.p, m.player, m.imgLoad));
            }
            for(int i =0; i<5;i++){
                PVector getRandomSpawn = getRandomSpawn(m.player.p);

                m.enemies.add(new CheeseGhast((int) getRandomSpawn.x, (int) getRandomSpawn.y,   m.player.position, m.player.p, m.player,m.imgLoad));

            }
            for(int i =0; i<12;i++) {
                PVector getRandomSpawn = getRandomSpawn(m.player.p);

                m.enemies.add(new Uzzi((int) getRandomSpawn.x, (int) getRandomSpawn.y, m.player.position, m.player.p, m.player, m.imgLoad));
            }
        }

        else{
            m.location.location=LocationType.shop;
for (int i =0; i<m.grid.size();i++)
    if(m.grid.get(i).furnitureGridType == FurnitureTypes.door){
           m.player.position.x = m.grid.get(i).x+m.grid.get(i).width/4;
           m.player.position.y = m.grid.get(i).y+m.grid.get(i).height/4;
        m.camera.mode = 0;
        m.player.playerHealth = 100;
        m.player.dead = false;
    }
        }

    }

    PVector getRandomSpawn(PApplet p){
    PVector result;
    result= new PVector();
    boolean check = true;
    while(check){
        result.set(p.random(0, 3000),p.random(0, 3000));
        if(result.x>1000||result.y>1000)
        check = false;


    }


    return  result;
    }

}
