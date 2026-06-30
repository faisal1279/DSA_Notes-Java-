package BST;

import java.util.ArrayList;

public class kthSmallestEle {
    static int ans;
    static int k2;
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
        
        System.out.println(kthSmallestElement(root, 4));
        System.out.println(kthSmallestElement2(root, 5));


    }

    public static void inorder2(Node root){
        if(root == null) return;
        inorder2(root.left);
        k2--;
        if(k2 == 0) ans = root.val;
        inorder2(root.right);
    }
    public static int kthSmallestElement2(Node root,int k) {
        k2 = k;
        ans = -1;
        inorder2(root);
        return ans;
    }
    public static void inorder(Node root,ArrayList<Integer> arr){
        if(root == null) return;
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
    }
    // with extra space
    public static int kthSmallestElement(Node root,int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        inorder(root,arr);
        System.out.println(arr);
        if(arr.size() < k) return -1;
        return arr.get(k-1);
    }
    
}
