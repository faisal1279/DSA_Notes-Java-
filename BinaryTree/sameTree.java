package binaryTree;

public class sameTree {
        static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }
    public static void main(String[] args) {
       Node p = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);

        p.left = a;
        p.right = b;

        Node q = new Node(1);
        Node c = new Node(2);
        Node d = new Node(3);
        // q.left = c;
        q.right = d;
        System.out.println(isSameTree(p, q));
    }
    static boolean isSameTree(Node p,Node q){
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
