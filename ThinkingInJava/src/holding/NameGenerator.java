package holding;

import java.util.Random;

/**
 * Created by aleks on 14.10.15.
 */
public class NameGenerator {
    private int counter = 0;
    private int bound = 0;
    public NameGenerator(int bound){
        this.bound = bound;
    }
    public String next(){
        String tempName = "name" + counter;
        counter++;
        if (counter > bound)
            counter = 0;
        return tempName;
    }
}
