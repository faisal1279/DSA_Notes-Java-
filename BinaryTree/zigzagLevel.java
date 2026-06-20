package binaryTree;

import java.util.*;

public class zigzagLevel {
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


        int level = 1+height(root);
        System.out.println(level);

        List<List<Integer>> ans = zigzag(root);
        System.out.println(ans);

    }
    static List<List<Integer>> zigzag(Node root){
        List<List<Integer>> ans = new ArrayList<>();
        int level = 1+height(root);
        for(int i=1;i<=level;i++){
            List<Integer> arr = new ArrayList<>();
            if(i%2==0){
                nthLevel2(root, i, arr);
            }else{
                nthLevel(root, i, arr);
            }
            ans.add(arr);
        }
        return ans;
    }
    static void nthLevel2(Node root,int n,List<Integer> arr){
        if(root == null) return;
        if(n==1){
            arr.add(root.val);
        }
        nthLevel2(root.right, n-1,arr);
        nthLevel2(root.left, n-1,arr);
    }
    static void nthLevel(Node root,int n,List<Integer> arr){
        if(root == null) return;
        if(n==1){
            arr.add(root.val);
        }
        nthLevel(root.left, n-1,arr);
        nthLevel(root.right, n-1,arr);
    }
    static int height(Node root){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 0;
        return 1+Math.max(height(root.left), height(root.right));
    }
}
