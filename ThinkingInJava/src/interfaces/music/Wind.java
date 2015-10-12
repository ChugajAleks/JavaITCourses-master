package interfaces.music;

/**
 * Created by Алекс on 26.09.15.
 */
public class Wind implements Instrument {
    @Override
    public void play(Note note){
        System.out.println(this +" .play() " + note);
    }

    @Override
    public String toString() {
        return "Wind";
    }

    @Override
    public void adjust() {
        System.out.println(this + ".adjust()");
    }
}
