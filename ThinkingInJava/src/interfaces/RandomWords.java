package interfaces;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Алекс on 06.10.15.
 */
public class RandomWords implements Readable{
    private Random rand = new Random(47);
    private final char[] capital = "QWERTYUIOPASDFGHJKLZXCVBNM".toCharArray();
    private final char[] lowers = "qwertyuiopasdfghjklzxcvbnm".toCharArray();
    private final char[] volets = "aeuio".toCharArray();
    private int count;

    public RandomWords(int count) {
        this.count = count;
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if(count-- == 0)
        return -1;

        cb.append(capital[rand.nextInt(capital.length)]);
        for (int i = 0; i < 4; i++) {
            cb.append(volets[rand.nextInt(volets.length)]);
            cb.append(lowers[rand.nextInt(lowers.length)]);
        }
        cb.append(" ");
        return 10;
    }
}

class Main{
    public static void main(String[] args) {
        Scanner s = new Scanner(new RandomWords(10));
        while (s.hasNext())
            System.out.println(s.next());
    }
}