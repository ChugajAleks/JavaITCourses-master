package Polimorphism.music;

/**
 * Created by Алекс on 26.09.15.
 */
public class Wind extends Instrument {
    @Override
    public void play(Note note){
        System.out.println("Wind.play() " + note);
    }

    @Override
    public String toString() {
        return "Wind";
    }

    @Override
    void adjust() {
        System.out.println("Adjust Wind");
    }
}
