package Polimorphism.music;

/**
 * Created by Алекс on 26.09.15.
 */
public class Instrument {
    void play(Note note){
        System.out.println("Instrument.play()" + note);
    }
    public String toString(){
        return "Instrument";
    }
    void adjust(){
        System.out.println("Adjust Instrument");
    }
}
