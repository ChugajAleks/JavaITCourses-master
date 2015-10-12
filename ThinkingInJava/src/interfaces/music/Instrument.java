package interfaces.music;

/**
 * Created by Алекс on 26.09.15.
 */
public interface Instrument {
    int VALUE = 5;
    void play(Note note);
    void adjust();
}
