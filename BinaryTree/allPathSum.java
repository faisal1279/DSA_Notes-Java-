package binaryTree;

import java.util.ArrayList;
import java.util.List;

public class allPathSum {
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

        List<Integer> ans = new ArrayList<>();
        helper(root,ans,0);
        System.out.println(ans);
    }
    public static void  helper(Node root,List<Integer> ans,int s){
        if(root == null) return;
        if(root.left == null && root.right == null){
            s+=root.val;
            ans.add(s);
            return;
        }
        helper(root.left, ans, s+root.val);
        helper(root.right, ans, s+root.val);
    }
}
