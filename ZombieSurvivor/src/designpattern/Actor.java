package designpattern;
import jplay.Sprite;
public abstract class Actor extends Sprite implements ActorInterface{
    double velocity=1;
    boolean alive=true;
    double life;
    double strenght;
    double pointsperdeath;
    
    public Actor(int x,int y,String image) {
        super((image),1);
        this.x=x;
        this.y=y;
    }

    public void death(){
        this.x=-6666;
        this.y=-6666;
        this.alive=false;
    }
    
    @Override
    public void receiveDamage(double damage){
        this.life-=damage;
    }
    
    public void follow(double x, double y){
        if(this.x>x){
            this.x-=this.velocity;
        }else{
            this.x+=this.velocity;
        }
        if(this.y>y){
            this.y-=this.velocity;
        }else{
            this.y+=this.velocity;
        }
    }
    
    public void attack(Actor ac){
        ac.receiveDamage(this.strenght);
    }
    
}



//https://i.pinimg.com/236x/5a/0f/79/5a0f79b389396c9f0ec448bdcbc2439e--minecraft-pixel-art-lego-mosaic.jpg
//https://mir-s3-cdn-cf.behance.net/project_modules/disp/f4187f15824521.562976f232386.png