package Polimorphism.music;

/**
 * Created by Алекс on 26.09.15.
 */
public class Woodwind extends Instrument {
    @Override
    public void play(Note note) {
        System.out.println("Woodwind.play() " + note);
    }

    @Override
    public String toString() {
        return "Woodwind";
    }

    public void drill(){
        System.out.println("Woodwind is drilled");
    }
}