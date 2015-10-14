package holding;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by aleks on 13.10.15.
 */
public class SimpleCollection {
    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++) {
            collection.add(i);
        }
        for (Integer i : collection){
            System.out.println(i);
        }
        System.out.println(collection.contains(4));

    }
}
