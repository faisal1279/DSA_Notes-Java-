package binaryTree;

public class pathsum03 {
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
        Node b = new Node(5);                 // 2   5
        root.left = a;                          //  / \   \
        root.right = b;                        //  1   5   -3
        Node c = new Node(1);              // /        \
        Node d = new Node(5);        //     -1          8
        Node e = new Node(-3);
        Node f = new Node(-1);

        a.left = c;
        a.right = d;

        b.right = e;
        c.left = f;

        int count = pathSum(root,3);
        System.out.println(count);
    }
    static int helper(Node root,int sum){
        if(root == null) return 0;
        int count = 0;
        if(root.val == sum) count++;
        return count + helper(root.left, sum-root.val) + helper(root.right, sum-root.val); 
    }
    static int pathSum(Node root,int sum){
        if(root == null) return 0;
        int count = helper(root,sum);
        count+=pathSum(root.left, sum) + pathSum(root.right, sum);
        return count;
    }
}
