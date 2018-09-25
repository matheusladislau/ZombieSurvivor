package designpattern;
public class Player extends Actor{
    public Player(int x, int y, String image) {
        super(x,y,image);
        this.velocity=0.9;
        this.strenght=2;
        this.life=100;
    }   
}
