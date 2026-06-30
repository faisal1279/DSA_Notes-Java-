package BST;

public class LCA {
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
        System.out.println(lowestCommonAnsestor(root,10,12));
    }
    public static int lowestCommonAnsestor(Node root,int p,int q){
        if(root.val>p && root.val>q) return lowestCommonAnsestor(root.left,p,q);
        else if(root.val<p && root.val<q) return lowestCommonAnsestor(root.right,p,q);
        else return root.val;
    }
}
