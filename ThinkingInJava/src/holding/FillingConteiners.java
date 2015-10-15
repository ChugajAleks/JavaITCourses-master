package holding;

import java.util.*;

/**
 * Created by aleks on 13.10.15.
 */
public class FillingConteiners {
    private NameGenerator generator = new NameGenerator(5);

    Collection fill(Collection<String> collection){
        for (int i = 0; i < 8; i++) {
            collection.add(generator.next());
        }
        return collection;
    }

    Map fill(Map<String, String> map){
        for (int i = 0; i < 8; i++) {
            map.put(generator.next(), generator.next());
        }
        return map;
    }

    String[] fill(String[] array){
        for (int i = 0; i < 8; i++) {
            array[i] = generator.next();
        }
        return array;
    }
//    public static void main(String[] args) {
//        System.out.println(fill(new ArrayList<String>()));
//        System.out.println(fill(new LinkedList<String>()));
//        System.out.println(fill(new HashSet<String>()));
//        System.out.println(fill(new TreeSet<String>()));
//        System.out.println(fill(new LinkedHashSet<String>()));
//        System.out.println(fill(new HashMap<String, String>()));
//        System.out.println(fill(new TreeMap<String, String>()));
//        System.out.println(fill(new LinkedHashMap<String, String>()));
//        System.out.println(Arrays.toString(fill(new String[10])));
//    }
}

class DemoFillingCollections{
    public static void main(String[] args) {
        FillingConteiners fillingConteiners = new FillingConteiners();
        System.out.println(fillingConteiners.fill(new ArrayList<String>()));
        System.out.println(fillingConteiners.fill(new LinkedList<String>()));
        System.out.println(fillingConteiners.fill(new HashSet<String>()));
        System.out.println(fillingConteiners.fill(new TreeSet<String>()));
        System.out.println(fillingConteiners.fill(new LinkedHashSet<String>()));
        System.out.println(fillingConteiners.fill(new HashMap<String, String>()));
        System.out.println(fillingConteiners.fill(new TreeMap<String, String>()));
        System.out.println(fillingConteiners.fill(new LinkedHashMap<String, String>()));
        System.out.println(Arrays.toString(fillingConteiners.fill(new String[10])));
    }
}
