package binaryTree;

import java.util.ArrayList;
import java.util.List;

public class pathSum02 {
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
        root.right = b;                        //  15   5   6
        Node c = new Node(15);              //          \
        Node d = new Node(5);               //          8
        Node e = new Node(6);
        Node f = new Node(8);

        a.left = c;
        a.right = d;

        b.right = e;
        e.right = f;
        List<List<Integer>> ans = pathSum(root,18);
        System.out.println(ans);
    }
    static void helper(Node root,List<List<Integer>> ans,List<Integer> arr,int sum){
        if(root == null) return;
        if(root != null && root.left == null && root.right == null){
            arr.add(root.val);
            if(root.val == sum){
                List<Integer> a = new ArrayList<>();
                for(int i=0;i<arr.size();i++){
                    a.add(arr.get(i));
                }
                ans.add(a);
            }
            arr.remove(arr.size()-1);
            return;
        }
        arr.add(root.val);
        helper(root.left, ans, arr, sum-root.val);
        helper(root.right, ans, arr, sum-root.val);
    }
    static List<List<Integer>> pathSum(Node root,int sum){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        helper(root,ans,arr,sum);
        return ans;
    }
}
