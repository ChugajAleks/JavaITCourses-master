package Polimorphism.music;

/**
 * Created by Алекс on 26.09.15.
 */
public class Percussion extends Instrument {
    @Override
    public void play(Note note){
        System.out.println("Percussion.play() " + note);
    }

    @Override
    public String toString() {
        return "Percussion";
    }

    @Override
    void adjust() {
        System.out.println("Adjust Percussion");
    }
}
