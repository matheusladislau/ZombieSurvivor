package designpattern;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import jplay.Keyboard;
import jplay.Scene;
import jplay.URL;
import jplay.Window;
public class Level{
    private final Window window;
    private final Keyboard keyboard;
//    private final GameImage background;
    private Actor player;
    private Actor[] monsterbig;
    private Actor[] monstermini;
    private Actor[] monstermedium;
    private Scene scene=new Scene();
    double minx=2;
    double miny=2;
    double maxx=748;
    double maxy=558;
    Music music=new Music();
    int state=0;
    public int points=0;
    Gun arma=new Gun();
//
    public void showPoints(Window window){
        Font f=new Font("arial",Font.BOLD,18);
        window.drawText(("SCORE: "+this.points),15,30,Color.yellow,f);
        window.drawText(("LIFE: "+String.format("%.1f",player.life)),15,60,Color.yellow,f);
       
    }
//
    public Level(Window window){
        this.window=window;
        keyboard=window.getKeyboard();
        scene.loadFromFile(URL.scenario("scene.scn"));
        generateActors();
        music.play("strongermonsters.wav");
        while(state==0){
            scene.draw();
                player.draw();
                for(int i=0; i<monsterbig.length; i++){
                    monsterbig[i].draw();
                }
                for(int i=0; i<monstermedium.length; i++){
                    monstermedium[i].draw();
                }
                for(int i=0; i<monstermini.length; i++){
                    monstermini[i].draw();
                }
                window.update();
            
            JOptionPane.showMessageDialog(null,"Zombie Survivor do Sucesso"
                    + "\n\nAperte os direcionais para andar"
                    + "\nA,S,D,espaço para atirar"
                    + "\nDerrote os zumbis para vencer"
                    + "\nSe chegar a zero de vida você perde.\n\nBoa sorte!");
               state=1;
            
        }
        while(state==1){
            run();
        }
    }
    
    public void run(){
        while(true){
            update();
            showPoints(window);
            keyboardAction();
        }
    }
    
    public void update(){
        if(!player.alive)
            endGame(false);
        
        scene.draw();
        player.draw();
        
        for (Actor mbig : monsterbig) {
            if (mbig.alive) {
                if (mbig.life >=0) {
                    mbig.follow(player.x, player.y);
                    mbig.draw();
                    if(arma.verifyCollision((int)mbig.x,(int)mbig.y,40)){
                        mbig.receiveDamage(arma.getDamage());
                    }
                } else {
                    points+=mbig.pointsperdeath;
                    mbig.death();
                }
            }
        }
        for (Actor mmediunm : monstermedium) {
            if (mmediunm.alive) {
                if (mmediunm.life >=0) {
                    mmediunm.follow(player.x, player.y);
                    mmediunm.draw();
                    if(arma.verifyCollision((int)mmediunm.x,(int)mmediunm.y,40)){
                        mmediunm.receiveDamage(arma.getDamage());
                    }
                } else {
                    points+=mmediunm.pointsperdeath;
                    mmediunm.death();
                }
            }
        }
        for(Actor mmini : monstermini) {
            if (mmini.alive) {
                if (mmini.life >=0) {
                    mmini.follow(player.x, player.y);
                    mmini.draw();
                if(arma.verifyCollision((int)mmini.x,(int)mmini.y,40)){
                        mmini.receiveDamage(arma.getDamage());
                    }
                } else {
                    points+=mmini.pointsperdeath;
                    mmini.death();
                }
            }
        }
        verifyDamage();
        showPoints(window);
        window.update();
        arma.run();

        if(points==(monsterbig.length*3)+(monstermedium.length*2)+(monstermini.length*1))
            endGame(true);
    }

    public void verifyDamage(){
        int proximity=37;
        for (Actor mbig : monsterbig) {
            if ((player.x > mbig.x) && (player.x - mbig.x < proximity)) {
                if ((player.y > mbig.y) && (player.y - mbig.y < proximity)) {
                    mbig.attack(player);
                }
            }
            if ((player.x < mbig.x) && (mbig.x - player.x < proximity)) {
                if ((player.y < mbig.y) && (mbig.y - player.y < proximity)) {
                    mbig.attack(player);
                }
            }
        }

        for (Actor mmedium : monstermedium) {
            if ((player.x > mmedium.x) && (player.x - mmedium.x < proximity)) {
                if ((player.y > mmedium.y) && (player.y - mmedium.y < proximity)) {
                    mmedium.attack(player);
                }
            }
            if ((player.x < mmedium.x) && (mmedium.x - player.x < proximity)) {
                if ((player.y < mmedium.y) && (mmedium.y - player.y < proximity)) {
                    mmedium.attack(player);
                }
            }
        }
        for (Actor mmini : monstermini) {
            if ((player.x > mmini.x) && (player.x - mmini.x < proximity)) {
                if ((player.y > mmini.y) && (player.y - mmini.y < proximity)) {
                    mmini.attack(player);
                }
            }
            if ((player.x < mmini.x) && (mmini.x - player.x < proximity)) {
                if ((player.y < mmini.y) && (mmini.y - player.y < proximity)) {
                    mmini.attack(player);
                }
            }
        }
        if(player.life<=0){
            player.death();
        }
    }
      
    public void generateActors(){
        monsterbig=new MonsterBig[3];
        monstermedium=new MonsterMedium[5];
        monstermini=new MonsterMini[11];
        
        player=new ActorFactory().getActor("player");     

        for(int i=0; i<monsterbig.length; i++) {
            monsterbig[i]=new ActorFactory().getActor("monsterbig");                     
        }
        for(int i=0; i<monstermedium.length; i++) {
            monstermedium[i]=new ActorFactory().getActor("monstermedium");
        }
        for(int i=0; i<monstermini.length; i++) {
            monstermini[i]=new ActorFactory().getActor("monstermini");
        }   
    }
    
    public void atirar(int caminho){
        arma.newFlame((int)player.x,(int)player.y,caminho,scene);
    }
                  
    public void keyboardAction(){
       
    if(keyboard.keyDown(KeyEvent.VK_S))
        atirar(1);
        
    if(keyboard.keyDown(KeyEvent.VK_A))
        atirar(2);
    
    if(keyboard.keyDown(KeyEvent.VK_SPACE))
        atirar(3);
    
    if(keyboard.keyDown(KeyEvent.VK_D ))
        atirar(4);   
    
    if(keyboard.keyDown(keyboard.ESCAPE_KEY))    
        System.exit(0);                        
            
    if(player.y>miny)
        if(keyboard.keyDown(KeyEvent.VK_UP))
            player.y-=player.velocity;

    if(player.y<maxy)
        if(keyboard.keyDown(KeyEvent.VK_DOWN))
            player.y+=player.velocity;                

    if(player.x<maxx)
        if(keyboard.keyDown(KeyEvent.VK_RIGHT))
            player.x+=player.velocity;

    if(player.x>=minx)
        if(keyboard.keyDown(KeyEvent.VK_LEFT))
            player.x-=player.velocity;

    update();
    }
   
    public void endGame(boolean win){
        if(win){
            music.stop();
            music.play("last.wav","umavez");  
            JOptionPane.showMessageDialog(null,"You win!\n"
                + "Score: "+points+"\nLife: "+String.format("%.1f",player.life));
        }else{
            music.stop();
            music.play("zombie.wav","umavez");   
            music.play("zombie.wav","umavez");  
            music.play("zombie.wav","umavez");  
            JOptionPane.showMessageDialog(null,"Game Over!\n"
                + "Score: "+points);
        }
        music.stop();
        System.exit(0);
    }
 
}
