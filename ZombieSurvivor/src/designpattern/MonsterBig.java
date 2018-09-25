package designpattern;
import jplay.Sound;
import jplay.URL;
public class MonsterBig extends Actor{
    public MonsterBig(int x, int y, String image) {
        super(x, y, image);
        this.velocity=0.05;
        this.strenght=0.3;
        this.life=12;
        this.pointsperdeath=3;
    }
    
    @Override
    public void death(){
        this.x=-6666;
        this.y=-6666;
        this.alive=false;
        new Sound(URL.audio("zombie_death.wav")).play();
    }
}
