package interfaces.music;



/**
 * Created by Алекс on 26.09.15.
 */
enum Note{
MIDDLE_C, C_SHARP, B_FLAT
}

public class Music {
    public static void tune(Instrument i){
        i.play(Note.MIDDLE_C);
    }
    public static void tuneAll(Instrument[] instruments){
        for (Instrument iter : instruments)
            tune(iter);
    }

    public static void main(String[] args) {
        Instrument[] instruments = {
                new Wind(),
                new Percussion(),
                new Stringed(),
                new Brass(),
                new Woodwind()
        };
        tuneAll(instruments);
        instruments[4].adjust();
        System.out.println(instruments[1]);

        System.out.println("___________________");
        RandomGeneratorInstruments gen = new RandomGeneratorInstruments();
        for (int i = 0; i < 10; i++) {
            System.out.println(gen.nextInstrument() + "  " + i);
        }
    }
}
