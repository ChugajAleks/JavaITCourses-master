package Polimorphism.music;

/**
 * Created by Алекс on 26.09.15.
 */
public class Stringed extends Instrument {
    @Override
    public void play(Note note){
        System.out.println("Stringed.play() " + note);
    }

    @Override
    public String toString() {
        return "Stringed";
    }

    @Override
    void adjust() {
        System.out.println("Adjust Stringed");
    }
}
