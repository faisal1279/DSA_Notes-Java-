package BST;

import java.util.ArrayList;

public class MorrisTraversal {
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
        ArrayList<Integer> ans = traversal(root);
        System.out.println(ans);
    }
    static ArrayList<Integer> traversal(Node root){
        ArrayList<Integer> ans = new ArrayList<>();
        Node curr = root;
        while(curr != null){
            if(curr.left != null){
                Node pred = curr.left;
                while(pred.right != null && pred.right != curr) pred = pred.right;
                if(pred.right == null){
                    pred.right = curr;
                    curr = curr.left;
                }else{
                    pred.right = null;
                    ans.add(curr.val);
                    curr = curr.right;
                }
            }else{
                ans.add(curr.val);
                curr = curr.right;
            }
        }
        return ans;
    }
}
