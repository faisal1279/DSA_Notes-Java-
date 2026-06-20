package binaryTree;

public class diameter {
        static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);

        root.left = a;
        root.right = b;

        Node c = new Node(4);
        Node d = new Node(5);
        Node e = new Node(6);
        Node f = new Node(8);
        Node g = new Node(15);
        Node h = new Node(10);
        Node i = new Node(11);
        Node j = new Node(12);
        Node k = new Node(13);




        a.left = c;
        a.right = d;

        b.right = e;
        e.right = f;
        f.right = g;

        b.left = h;
        h.left = i;
        i.left = j;
        j.left = k;
        System.out.println(diameterofBinaryTree(root)); // leetcode 543
        
    }
    public static int diameterofBinaryTree(Node root){
        if(root == null || (root.left == null && root.right == null)) return 0;
        int left = diameterofBinaryTree(root.left);
        int right = diameterofBinaryTree(root.right);
        int mid = height(root.left) + height(root.right);
        if(root.left != null) mid++;
        if(root.right != null) mid++;
        return Math.max(mid, Math.max(left, right));
    }
    public static int height(Node root){
        if(root == null || (root.left == null && root.right == null)) return 0;
        int left = height(root.left);
        int right = height(root.right);
        return 1 + Math.max(left, right);
    }
}
