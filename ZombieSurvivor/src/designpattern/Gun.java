package designpattern;
import java.util.ArrayList;
import jplay.Scene;
import jplay.Sound;
import jplay.URL;
public class Gun {
    ArrayList<Flame> shoots = new ArrayList();
    boolean movendo;
    
    public void newFlame(int x,int y,int caminho,Scene scene){
        Flame f=new Flame(x,y,"src/image/flame.png",caminho);
        shoots.add(f);
        scene.addOverlay(f);
        soundDisparo();
    }
    public void run(){
        for (int i=0; i<shoots.size(); i++){
           shoots.get(i).move();
        }
    }
    
    public boolean verifyCollision(int x,int y,int diferenca){
        for (int i=0; i<shoots.size(); i++){
            if ((x > shoots.get(i).x) && (x - shoots.get(i).x < diferenca)) {
                if ((y > shoots.get(i).y) && (y - shoots.get(i).y < diferenca)) {
                    shoots.get(i).x=666;
                    shoots.get(i).y=666;
                    return true;
                }
            }
            if ((x < shoots.get(i).x) && (shoots.get(i).x - x < diferenca)) {
                if ((y < shoots.get(i).y) && (shoots.get(i).y - y < diferenca)) {
                    shoots.get(i).x=666;
                    shoots.get(i).y=666;
                    return true;
                }
            }
        }
        return false;
    }
    
    public double getDamage(){
        return shoots.get(0).strenght;
    }
    
    private void soundDisparo(){
        new Sound(URL.audio("fire.wav")).play();
    }
}
