package designpattern;

import jplay.Sound;
import jplay.URL;

public class MonsterMini extends Actor{
    public MonsterMini(int x, int y, String image) {
        super(x, y, image);
        this.velocity=0.3;
        this.strenght=0.05;
        this.life=2;
        this.pointsperdeath=1;
    }
   
    
    @Override
    public void death(){
        this.x=-6666;
        this.y=-6666;
        this.alive=false;
        new Sound(URL.audio("zombie_death.wav")).play();
    }
}
