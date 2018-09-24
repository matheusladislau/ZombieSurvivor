package designpattern;
import jplay.Sound;
import jplay.URL;
public class Music{
    private static Sound music;
    
    public static void play(String nome_musica){
        stop();
        music=new Sound(URL.audio(nome_musica));
        music.play();
        music.setRepeat(true);
    }
    
    public static void play(String music_name,String nada){
        music=new Sound(URL.audio(music_name));
        music.play();
        music.setRepeat(false);
    }
    public static void stop(){
        if(music!=null){
            music.stop();
        }
    }
}
