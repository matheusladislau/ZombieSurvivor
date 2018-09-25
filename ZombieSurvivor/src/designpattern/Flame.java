package designpattern;
public class Flame extends Actor{
    int caminho;
    boolean movendo;
    
    public Flame(double x, double y, String image,int caminho) {
        super((int)x,(int)y, image);
        this.velocity=0.6;
        this.strenght=2;
        this.caminho=caminho;
        this.movendo=true;
    }   
    
    public void move(){
        if(movendo){
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
}
