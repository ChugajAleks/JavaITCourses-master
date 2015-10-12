package Polimorphism.music;

/**
 * Created by Алекс on 26.09.15.
 */
public class Brass extends Instrument {
    @Override
    public void play(Note note){
        System.out.println("Brass.play() " + note);
    }

     @Override
    void adjust() {
        System.out.println("Adjust Brass");
    }
}
