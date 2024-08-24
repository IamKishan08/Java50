class Node{
    int key;
    Node left, right;
    Node(int data){
        key = data;
        left = right = null;
    }
}

public class BinarySearch {
    Node root;

    BinarySearch(){
        root = null;
    }

    void insert (int data){
        root = insertRec(root,data);
    }

    Node insertRec(Node root, int data){
        if(root == null){
            root = new Node(data);
            return root;
        }

        if(data < root.key){
            root.left = insertRec(root.left,data);
        } else if (data > root.key) {
            root.right = insertRec(root.right,data);
        }

        return root;
    }

    void traversal(){
        traversalRec(root);
    }

    void traversalRec(Node root){
        if(root != null){

            //Inorder Traversal(left , root node , right ) , PreOrder Traversal ->(root node , left , right) , PostOrder Traversal(left, right , root node)
            traversalRec(root.left);
            System.out.println(root.key + " ");
            traversalRec(root.right);
        }
    }

    public static void main(String[] args) {
        BinarySearch bt = new BinarySearch();

        bt.insert(50);
        bt.insert(30);
        bt.insert(20);
        bt.insert(40);
        bt.insert(70);
        bt.insert(60);
        bt.insert(80);

        bt.traversal();
    }

}
