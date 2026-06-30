package BST;

class QuadSum{
    int max;
    int min;
    int sum;
    boolean isBST;
    public QuadSum(int max,int min,int sum,boolean isBST) {
        this.max = max;
        this.min = min;
        this.sum = sum;
        this.isBST = isBST;
    }
}
public class largestBSTSum {
    static int maxsum;
    static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }
    public static void main(String[] args) {
        Node root = new Node(9);           //      9              
        Node a = new Node(10);            //       / \               
        Node b = new Node(11);          //       3   11      
        root.left = a;                      //       /\   /\           
        root.right = b;                     //      2  5 10 12       
        Node c = new Node(2);          //      /                  
        Node d = new Node(5);          //     1                 
        
        a.left = c;
        a.right = d;

        Node e = new Node(10);
        Node f = new Node(12);
        b.left = e;
        b.right = f;

        Node g = new Node(1);
        c.left = g;
        System.out.println(largestBST(root));
    }
    public static int largestBST(Node root){
        maxsum = 0;
        helper(root);
        return maxsum;
    }
    public static QuadSum helper(Node root){
        if(root == null) return new QuadSum(Integer.MIN_VALUE, Integer.MAX_VALUE, 0, true);
        QuadSum lst = helper(root.left);
        QuadSum rst = helper(root.right);

        int max = Math.max(root.val, Math.max(lst.max, rst.max));
        int min = Math.min(root.val, Math.min(lst.min, rst.min));

        int sum = root.val + lst.sum + rst.sum;

        boolean isBST = lst.isBST && rst.isBST && (lst.max < root.val) && (rst.min > root.val);

        if(isBST) maxsum = Math.max(sum,maxsum);

        return new QuadSum(max, min, sum, isBST);
    }
}
