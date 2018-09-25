package designpattern;
public class MonsterMedium extends Actor{
    public MonsterMedium(int x, int y, String image) {
        super(x, y, image);
        this.velocity=0.2;
        this.strenght=0.1;
        this.life=6;
        this.pointsperdeath=2;
    }
}
