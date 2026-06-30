package BST;

import java.util.ArrayList;

public class bstGreaterSumTree {
    static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }
    static int sum;
    public static void main(String[] args) {
        Node root = new Node(9);           //      9                 42
        Node a = new Node(3);            //       / \               /  \
        Node b = new Node(11);          //       3   11      ->    50   23 
        root.left = a;                      //       /\   /\           /\    /\
        root.right = b;                     //      2  5 10 12        52 47 33 12 
        Node c = new Node(2);          //      /                 / 
        Node d = new Node(5);          //     1                 53       
        
        a.left = c;
        a.right = d;

        Node e = new Node(10);
        Node f = new Node(12);
        b.left = e;
        b.right = f;

        Node g = new Node(1);
        c.left = g;


        // display(root);
        // System.out.println();
        // //withoutSpace
        // transformTree(root);
        // display(root);

        System.out.println();
        display(root);
        System.out.println();
        //withoutSpace
        transformTree2(root);
        display(root);
    }

    public static void transformTree2(Node root){
        ArrayList<Node> arr = new ArrayList();
        revInOrder2(root,arr);
        int sums = 0;
        for(int i=0;i<arr.size();i++){
            sums += arr.get(i).val;
            arr.get(i).val = sums;
        }
    }
    public static void revInOrder2(Node root,ArrayList<Node> arr){
        if(root == null) return;
        revInOrder2(root.right,arr);
        arr.add(root);
        revInOrder2(root.left,arr);
    }
    public static void display(Node root){
        if(root == null) return;
        display(root.left);
        System.out.print(root.val+" ");
        display(root.right);
    }
    public static void revInOrder(Node root){
        if(root == null) return;
        revInOrder(root.right);
        sum+= root.val;
        root.val = sum;
        revInOrder(root.left);
    }
    public static void transformTree(Node root){
        sum = 0;
        revInOrder(root);
    }
}
