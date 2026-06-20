package binaryTree;

public class pathSum01 {
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
        System.out.println(hasPathSum(root,7));

    }
    static boolean hasPathSum(Node root,int sum){
        if(root == null){
            return false;
        }
        if(root != null && root.left == null && root.right == null){
            if(root.val == sum) return true;
        }
        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
    }
}
