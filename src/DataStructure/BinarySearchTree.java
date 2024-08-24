package DataStructure;

class Node{
    int key ;
    Node left , right;

    Node(int data){
        key = data;
        left = right = null;
    }
}

public class BinarySearchTree {


    Node root;

    BinarySearchTree(){
        root = null;
    }

    void insert(int key){
        root = insertrec(root, key);
    }

    Node insertrec(Node root, int key){

        if(root == null){
            root = new Node(key);
            return root;
        }

        if(key < root.key){
            root.left = insertrec(root.left,key);
        } else if (key> root.key) {
            root.right = insertrec(root.right, key);
        }
        return root;
    }

    void inorder(){
        inOrderRec(root);
    }

    void inOrderRec(Node root){
        if(root != null){
            inOrderRec(root.left);
            System.out.println(root.key + " ");
            inOrderRec(root.right);
        }
    }

    public static void main(String[] args) {

        BinarySearchTree bt = new BinarySearchTree();

        bt.insert(50);
        bt.insert(30);
        bt.insert(20);
        bt.insert(40);
        bt.insert(70);
        bt.insert(60);
        bt.insert(80);


        bt.inorder();
    }
}
