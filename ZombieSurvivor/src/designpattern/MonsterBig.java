package designpattern;
public class MonsterBig extends Actor{
    public MonsterBig(int x, int y, String image) {
        super(x, y, image);
        this.velocity=0.05;
        this.strenght=0.3;
        this.life=12;
        this.pointsperdeath=3;
    }
}
