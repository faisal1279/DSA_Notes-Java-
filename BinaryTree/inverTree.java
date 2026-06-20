package binaryTree;

public class inverTree {
    static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);                // 1
        Node a = new Node(2);                 //  / \
        Node b = new Node(3);                 // 2   3
        root.left = a;                          //  / \   \
        root.right = b;                        //  4   5   6
        Node c = new Node(4);              //          \
        Node d = new Node(5);               //          8
        Node e = new Node(6);
        Node f = new Node(8);

        a.left = c;
        a.right = d;

        b.right = e;
        e.right = f;

        inOrder(root);
        System.out.println();
        Node temp = inverTreeMet(root);
        inOrder(temp);
    }
    static Node inverTreeMet(Node root){
        if(root == null) return root;
        Node l = root.left;
        Node r = root.right;
        root.left = inverTreeMet(r);
        root.right = inverTreeMet(l);
        return root;
    }
    static void inOrder(Node root){
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }
}
