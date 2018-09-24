package designpattern;
public class MonsterMini extends Actor{
    
    public MonsterMini(int x, int y, String image) {
        super(x, y, image);
        this.velocity=0.3;
        this.strenght=0.05;
        this.life=2;
        this.pointsperdeath=1;
    }
}
