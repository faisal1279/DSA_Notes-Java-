package BST;

import java.util.ArrayList;

public class deleteNode_2Child {
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
        root = deleteNode(root,9);
        ans = traversal(root);
        System.out.println(ans);
    }
    static Node deleteNode(Node root,int target){
        if(root.val > target){
            root.left = deleteNode(root.left, target);
        }else if(root.val < target){
            root.right = deleteNode(root.right, target);
        }else{ // root.val = target
            // case 1 Leaf Node
            if(root.left == null && root.right == null) return null;
            // case 2 1 child Node
            if(root.right == null) return root.left;
            else if(root.right == null) return root.right;
            // case 3 2 child Node
            Node pred = root.left;
            while(pred.right != null) pred = pred.right;
            root.left = deleteNode(root.left, pred.val);
            pred.left = root.left;
            pred.right = root.right;
            return pred;
        }
        return root;
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
