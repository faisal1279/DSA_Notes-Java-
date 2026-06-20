package binaryTree;

import java.util.*;

public class treImplementation {
    static int count = 0;
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
        display(root);
        System.out.println(size(root));
        preorder(root);
        System.out.println();
        System.out.println(count);
        System.out.println(sum(root));
        System.out.println(maxVal(root));
        System.out.println(height(root));
        inOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        System.out.println(minVal(root));
        System.out.println(product(root));
        bfs(root);
        nthLevel(root,2);

    }
    static void nthLevel(Node root,int n){
        if(root == null) return;
        if(n==1){
            System.out.print(root.val+" ");
            return;
        }
        nthLevel(root.left, n-1);
        nthLevel(root.right, n-1);
    }
    static void bfs(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(q.size()>0){
            Node temp = q.peek();
            if(temp.left != null) q.add(temp.left);
            if(temp.right != null) q.add(temp.right);
            System.out.print(temp.val+" ");
            q.remove();
        }
        System.out.println();
    }
    static int product(Node root){
        if(root == null) return 1;
        return root.val * product(root.left) * product(root.right);
    }
    static int minVal(Node root){
        if(root == null) return Integer.MAX_VALUE;
        return Math.min(root.val, Math.min(minVal(root.left), minVal(root.right)));
    }
    static void postOrder(Node root){
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }
    static void inOrder(Node root){
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }
    static int height(Node root){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 0;
        return 1 + Math.max(height(root.left),height(root.right));
    }
    static int maxVal(Node root){
        if(root == null) return Integer.MIN_VALUE;
        return Math.max(root.val, Math.max(maxVal(root.left), maxVal(root.right)));
    }
    static int sum(Node root){
        if(root == null) return 0;
        return root.val + sum(root.left) + sum(root.right);
    }
    static void preorder(Node root){
        if(root == null) return;
        System.out.print(root.val + " ");
        count++;
        preorder(root.left);
        preorder(root.right);
    }
   static void display(Node root){
        if(root == null) return;
        System.out.print(root.val+"->");
        if(root.left != null) System.out.print(root.left.val+" ");
        if(root.right != null) System.out.print(root.right.val+" ");
        System.out.println();
        display(root.left);
        display(root.right);
   }
   static int size(Node root){
        if(root == null) return 0;
        return 1 + size(root.left) +  size(root.right);
   }
}
