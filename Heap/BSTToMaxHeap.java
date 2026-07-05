package Heap;

import java.util.ArrayList;

public class BSTToMaxHeap {
    static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }
    public static void main(String[] args) {
        Node root = new Node(20);           //     20                 35
        Node a = new Node(10);                 //  / \               / \
        Node b = new Node(30);                 // 10  30    ->      15  30
        root.left = a;                          //   /\    /\           /\    /\
        root.right = b;                        //   5  15 25 35        5  10 20 25
        Node c = new Node(5);              //         
        Node d = new Node(15);               //        
        
        a.left = c;
        a.right = d;

        Node e = new Node(25);
        Node f = new Node(35);

        b.left = e; 
        b.right = f;
        display(root);
        System.out.println();
        convertToMaxHeap(root);
        display(root);
        System.out.println();
    }
    static int idx;
    public static void convertToMaxHeap(Node root){
        idx = 0;
        ArrayList<Integer> in = new ArrayList<>();
        inOrder(root,in);
        postOrder(root,in);
    }
    public static void postOrder(Node root,ArrayList<Integer> in){
        if(root == null) return;
        postOrder(root.left, in);
        postOrder(root.right, in);
        root.val = in.get(idx++);

    }
    public static void inOrder(Node root,ArrayList<Integer> in){
        if(root == null) return;
        inOrder(root.left, in);
        in.add(root.val);
        inOrder(root.right, in);
    }
    public static void display(Node root){
        if(root == null) return;
        display(root.left);
        System.out.print(root.val+" ");
        display(root.right);
    }
}
