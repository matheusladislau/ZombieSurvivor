package designpattern;
public interface ActorInterface{
    
    public void death();
    
    public void receiveDamage(double damage);
    
    public void follow(double x, double y);
    
    public void attack(Actor ac);
}
