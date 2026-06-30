package BST;
class Pair{
    int max;
    int min;
    Pair(int max,int min){
        this.max = max;
        this.min = min;
    }
}
public class validateBST {
    static boolean flag;

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
        Node a = new Node(3);            //       / \               
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

        System.out.println(isBST(root));
    }
    public static boolean isBST(Node root){
        flag = true;
        maxMin(root);
        return flag;
    }
    public static Pair maxMin(Node root){
        if(root == null) return new Pair(Integer.MIN_VALUE, Integer.MAX_VALUE);
        Pair lst = maxMin(root.left);
        Pair rst = maxMin(root.right);
        int max = Math.max(root.val,Math.max(lst.max, rst.max));
        int min = Math.min(root.val,Math.min(lst.min, rst.min));

        if(lst.max>=root.val || rst.min<=root.val) flag = false;

        return new Pair(max, min);
    }
}
