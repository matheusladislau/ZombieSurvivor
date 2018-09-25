package designpattern;
import jplay.Sound;
import jplay.URL;
public class MonsterMedium extends Actor{
    public MonsterMedium(int x, int y, String image) {
        super(x, y, image);
        this.velocity=0.2;
        this.strenght=0.1;
        this.life=6;
        this.pointsperdeath=2;
    }
    
    @Override
    public void death(){
        this.alive=false;
        this.x=-6666;
        this.y=-6666;
        new Sound(URL.audio("zombie_death.wav")).play();
    }
}
