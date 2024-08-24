package DataStructure;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.ArrayDeque;

public class queueExample {
    public static void main(String[] args) {

        // three types of classes can be used for  queue is LinkedList, PriorityQueue, Deque
        Queue<Integer> queueLinkedList = new LinkedList<>();
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        Deque<String> deque = new ArrayDeque<>();   // addFirst , addLast , offerFirst , offerLast ,

        queueLinkedList.add(1);
        queueLinkedList.add(2);
        queueLinkedList.add(3);
        //queueLinkedList.poll(); //// remove the first element
        int firstElement = queueLinkedList.peek(); // return first element without removing
        System.out.println("Queue using Linked list "+firstElement);
        System.out.println(queueLinkedList);


        priorityQueue.add(50);
        priorityQueue.add(25);
        priorityQueue.add(10);
        System.out.println(priorityQueue);  // print element based on the priority from the smallest to largest

        deque.addLast("First");
        deque.addLast("Second");
        deque.addLast("Third");
        deque.offerFirst("Kishan");
        System.out.println(deque);
    }
}
