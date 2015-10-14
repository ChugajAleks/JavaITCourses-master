package holding;

import java.util.*;

/**
 * Created by aleks on 13.10.15.
 */
public class PrintingContainers {
    static Collection fill(Collection<String> collection){
        collection.add("криса");
        collection.add("кошка");
        collection.add("собака");
        collection.add("собака");
        return collection;
    }

    static Map fill(Map<String, String> map){
        map.put("краса", "анфиса");
        map.put("кошка", "мурка");
        map.put("собака", "тузик");
        map.put("собака", "бобик");
        return map;
    }

    public static void main(String[] args) {
        System.out.println(fill(new ArrayList<String>()));
        System.out.println(fill(new LinkedList<String>()));
        System.out.println(fill(new HashSet<String>()));
        System.out.println(fill(new TreeSet<String>()));
        System.out.println(fill(new LinkedHashSet<String>()));
        System.out.println(fill(new HashMap<String, String>()));
        System.out.println(fill(new TreeMap<String, String>()));
        System.out.println(fill(new LinkedHashMap<String, String>()));
    }
}
