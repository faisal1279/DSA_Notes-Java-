package binaryTree;

public class balanced {
        static int count = 0;
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



        a.left = c;
        a.right = d;

        b.right = e;
        e.right = f;
        System.out.println(balancedTree(root));
    }
    public static boolean  balancedTree(Node root){
        if(root == null) return true;
        int left = height(root.left);
        int right = height(root.right);
        if(root.left != null) left++;
        if(root.right != null) right++;
        int d = left - right;
        if(d<0){
            d = - d;
        }
        if(d>1){
            System.out.println(root.val);
            return false;
        } 
        return balancedTree(root.left) && balancedTree(root.right);
    }
    public static int height(Node root){
        if(root == null || (root.left == null && root.right == null)) return 0;
        int left = height(root.left);
        int right = height(root.right);
        return 1 + Math.max(left, right);
    }
}
