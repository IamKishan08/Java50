package DataStructure;

public class CircularLinkedList {

    static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    private Node head = null;
    private Node tail = null;

    public void addNode(int data){
        Node newNode = new Node(data);
        if ( head == null){
            head = newNode;
            tail = newNode;
            tail.next = head;
        }
        else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    public void displayNode(){
        Node current = head;
        do{
            System.out.println(current.data + " ");
            current = current.next;
        }while (current != head);
        System.out.println();
    }

    public void delete(){
        if(head == null){
            return;
        } else if (head == tail) {
            head = null;
            tail = null;
        }
        else {
            tail.next = head.next;
            head = head.next;
        }
    }


    public static void main(String[] args) {
        CircularLinkedList cc = new CircularLinkedList();

        cc.addNode(1);
        cc.addNode(2);
        cc.addNode(3);
        cc.addNode(4);

        cc.displayNode();

        cc.delete();

        cc.displayNode();

    }

}
