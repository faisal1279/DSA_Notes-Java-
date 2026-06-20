package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class morrisTraversal {
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
    static void flatten(Node root){
        Node curr = root;
        while(curr != null){
            if(curr.left != null){
                Node pred = curr.left;
                while(pred.right != null) pred = pred.right;
                pred.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
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
}
