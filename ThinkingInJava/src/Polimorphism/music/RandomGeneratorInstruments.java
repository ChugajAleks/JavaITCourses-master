package Polimorphism.music;

import java.util.Random;

/**
 * Created by Алекс on 27.09.15.
 */
public class RandomGeneratorInstruments {
    private Random rnd = new Random(47);
    public Instrument nextInstrument(){
        switch (rnd.nextInt(5)){
            default:
            case 0: return new Brass();
            case 1: return new Percussion();
            case 2: return new Wind();
            case 3: return new Stringed();
            case 4: return new Woodwind();
        }
    }
}
