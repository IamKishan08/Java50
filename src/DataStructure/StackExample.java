package DataStructure;

import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();


        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

       // stack.pop(); - remove the element last added
        stack.peek();  // return the last element inserted without removing
        stack.empty(); // check the stack is empty or not
        stack.search(4);   // search for the element and return the list

        System.out.println(stack.empty());


    }
}
