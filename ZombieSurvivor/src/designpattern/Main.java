package designpattern;
import jplay.Window;
/**
 *
 * @author Matheus Ladislau Ribeiro
 */
public class Main{
    public static void main(String args[]){
        Window window=new Window(800,600);
        Level level=new Level(window);
    }
}