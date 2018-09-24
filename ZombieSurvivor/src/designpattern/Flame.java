package designpattern;
public class Flame extends Actor{
    int caminho;
    public Flame(int x, int y, String image,int caminho) {
        super(x, y, image);
        this.velocity=0.6;
        this.strenght=2;
        this.caminho=caminho;
    }   
    
    public void move(){
        if(this.caminho==1)
            this.y-=velocity;
        if(this.caminho==2)
            this.x-=velocity;
        if(this.caminho==3)
            this.y+=velocity;
        if(this.caminho==4)
            this.x+=velocity;
    }
}
