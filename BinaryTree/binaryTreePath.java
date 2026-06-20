package binaryTree;

import java.util.*;

public class binaryTreePath {
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

        List<String> ans = new ArrayList<>();
        helper(root,ans,"");
        System.out.println(ans);
    }
    public static void  helper(Node root,List<String> ans,String s){
        if(root == null) return;
        if(root.left == null && root.right == null){
            s+=root.val;
            ans.add(s);
            return;
        }
        helper(root.left, ans, s+root.val+"->");
        helper(root.right, ans, s+root.val+"->");
    }
}
