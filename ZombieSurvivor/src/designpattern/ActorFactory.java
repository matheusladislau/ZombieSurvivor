package designpattern;
public class ActorFactory {
    double minx=2;
    double miny=2;
    double maxx=748;
    double maxy=558;
    
    public Actor getActor(String actorType){
        if(actorType == null){
            return null;
        }		
        if(actorType.equalsIgnoreCase("PLAYER")){
            return new Player(370,300,"src/image/player.png");
        }
        else if(actorType.equalsIgnoreCase("MONSTERBIG")){
            return (new MonsterBig(newX(),newY(),"src/image/gengar.png"));
        }
        else if(actorType.equalsIgnoreCase("MONSTERMEDIUM")){
            return (new MonsterMedium(newX(),newY(),"src/image/zombie.png")); 
        }
        else if(actorType.equalsIgnoreCase("MONSTERMINI")){
            return (new MonsterMini(newX(),newY(),"src/image/mini.png"));
        }
    return null;
    }
    
    public int newX(){
        int random_side =(int)(Math.random()*10);    
        int random =(int)(Math.random()*10);
        
        double resultado;
        //left
        if(random_side<=5){
            resultado=((random)*(maxx/2)/3);
        //right
        }else{
            resultado=((random)*(maxx/2)/3);
        }
        return (int)resultado/2;
    }
    
    public int newY(){
        int random_side =(int)(Math.random()*10);    
        int random =(int)(Math.random()*10);
        
        double resultado;
        //left
        if(random_side<=5){
            resultado=((random)*(maxy/2)/3);
        //right
        }else{
            resultado=((random)*(maxy/2)/3);
        }
        return (int)resultado/2;
    }
}
