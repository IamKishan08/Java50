package DataStructure;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapExample {
    public static void main(String[] args) {

        Map<String ,Integer> map = new HashMap<>();

        Map<String ,Integer> ll = new LinkedHashMap<>();

        Map<String ,Integer> tree = new TreeMap<>();

        map.put("Banana",4);
        map.put("Apple",3);
        map.put("Kiwi",2);
        map.put("Orange",6);
        map.put("Graph",2);

        System.out.println(map);

        boolean contains = map.containsKey("Kiwi");

        System.out.println(contains);

        int getKey = map.get("Apple"); // Retrieving Value by key

        System.out.println(getKey);

        map.remove("Banana");

        for (Map.Entry<String, Integer> entry : map.entrySet()){

            System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
        }


    }
}
