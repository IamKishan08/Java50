package DataStructure;

import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {

        LinkedList<String> ll = new LinkedList<>();


        ll.add("Mango");
        ll.add("Apple");
        ll.add("Orange");
        ll.addFirst("Kiwi");
        ll.addLast("Banana");

        System.out.println("Linked List Value"+ ll);

        String value = ll.get(2);
        System.out.println(value);

        ll.removeFirst();

        System.out.println(ll);


        for (String fruit : ll){
            System.out.println(fruit);
        }



    }
}
