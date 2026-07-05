package Heap;

public class checckMahHeapTree {
    static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }
    public static void main(String[] args) {
        Node root = new Node(10);                // 10
        Node a = new Node(5);                 //  / \
        Node b = new Node(8);                 // 5   8
        root.left = a;                          //   /\   /\
        root.right = b;                        //   1  4 7  2     
        Node c = new Node(1);              //         
        Node d = new Node(4);               //        
        
        a.left = c;
        a.right = d;

        Node e = new Node(7);
        Node f = new Node(2);

        b.left = e; 
        b.right = f;


        // d.right = e;

        // Node g = new Node(2);


        System.out.println(isHeap(root));
    }
    static int s;
    static boolean isHeap(Node root){
        s = size(root);
        return isMaxHeap(root) && isCBT(root,1);
    }
    public static boolean isCBT(Node root,int idx){
        if(root == null) return true;
        if(idx > s) return false;
        return isCBT(root.left, 2*idx) && isCBT(root.right, 2*idx+1);
    }
     static boolean isMaxHeap(Node root){
        if(root == null) return true;
        int leftVal = (root.left != null) ? root.left.val : Integer.MIN_VALUE;
        int rightVal = (root.right != null) ? root.right.val : Integer.MIN_VALUE;
        if(root.val <= leftVal || root.val <= rightVal) return false;
        return isMaxHeap(root.left) && isMaxHeap(root.right);
    }
     static int size(Node root){
        if(root == null) return 0;
        return 1 + size(root.left) + size(root.right); 
    }
}
