package interfaces.music;



/**
 * Created by ����� on 26.09.15.
 */
public class Stringed implements Instrument {
    @Override
    public void play(Note note){
        System.out.println(this + " .play() " + note);
    }

    @Override
    public String toString() {
        return "Stringed";
    }

    @Override
    public void adjust() {
        System.out.println(this + ".adjust()");
    }
}
