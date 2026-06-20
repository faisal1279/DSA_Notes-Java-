package binaryTree;
import java.util.*;
public class InfectedTree {
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
        Node a = new Node(5);                 //  / \
        Node b = new Node(3);                 // 5   3
        root.left = a;                          //  / \   \
        root.right = b;                        //  1   4   -3
        Node c = new Node(4);              // /        \
        Node d = new Node(10);        //     -1          8
        Node e = new Node(6);
        Node f = new Node(9);
        Node g = new Node(2);


        a.right = c;

        b.left = d;
        b.right = e;
        c.left = f; 
        c.right = g;
        System.out.println(amountOfTime(root, 3));

    }
    static int amountOfTime(Node root,int start){
        Node node = getNode(root, start);
        Map<Node,Node> p = new HashMap<>();
        preorder(root, p);
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        Map<Node,Integer> v = new HashMap<>();
        v.put(node, 0);
        while(q.size() >0){
            Node temp = q.peek();
            int level = v.get(temp);
            if(temp.left != null && !v.containsKey(temp.left)){
                q.add(temp.left);
                v.put(temp.left, level+1);
            }
            if(temp.right != null && !v.containsKey(temp.right)){
                q.add(temp.right);
                v.put(temp.right, level+1);
            }
            if(p.containsKey(temp) && !v.containsKey(p.get(temp))){
                q.add(p.get(temp));
                v.put(p.get(temp),level+1);
            }
            q.remove();
        }
        int max = -1;
        for(int level : v.values()){
            max = Math.max(max, level);
        }
        return max;
    }
    static Node getNode(Node root,int start){
        if(root == null) return null;
        if(root.val == start) return root;
        Node left = getNode(root.left, start);
        Node right = getNode(root.right, start);
        if(left == null) return right;
        else return left;
    }
    static void preorder(Node root,Map<Node,Node> p){
        if(root == null) return;
        if(root.left != null) p.put(root.left, root);
        if(root.right != null) p.put(root.right, root);
        preorder(root.left, p);
        preorder(root.right, p);
    }
}
