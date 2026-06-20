package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class flattenBinaryTree {
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
        Node b = new Node(5);                 // 2   5
        root.left = a;                          //  / \   \
        root.right = b;                        //  1   5   -3
        Node c = new Node(1);              // /        \
        Node d = new Node(5);        //     -1          8
        Node e = new Node(-3);
        Node f = new Node(-1);

        a.left = c;
        a.right = d;

        b.right = e;
        c.left = f;
        bfs(root);
        System.out.println();
        flatten(root);
        bfs(root);

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
    static void flatten(Node root){
        if(root ==null) return;
        Node left = root.left;
        Node right = root.right;
        root.left = null;
        flatten(root.left);
        flatten(root.right);
        root.right = left;
        Node temp = left;
        while(temp != null && temp.right != null){
            temp = temp.right;
        }
        if(temp != null) temp.right = right;
        else root.right = right;
        return;
    }
}
