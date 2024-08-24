package DataStructure;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {
    public static void main(String[] args) {

        Set<String> set = new HashSet<>();

        Set<String> ll = new LinkedHashSet<>();

        Set<String> tree = new TreeSet<>();


        set.add("Mango");
        set.add("Apple");
        set.add("Orange");
        set.add("Kiwi");

        ll.add("Mango");
        ll.add("Apple");
        ll.add("Orange");
        ll.add("Kiwi");

        System.out.println(set);

        //set.add("Apple");

       System.out.println(ll);

        boolean containsFruit = set.contains("Apple");
        System.out.println(containsFruit);

        for (String fruit : set) {
            System.out.println(fruit);
        }
    }
}
