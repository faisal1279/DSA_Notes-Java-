package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class constructBinaryTree {
    static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }
    public static void main(String[] args) {
        int preorder[] = {1,2,4,5,3,6};
        int inorder[] = {4,2,5,1,3,6};

        Node root = buildNode(preorder,inorder);
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
    static Node helper(int[] preor,int prelow,int prehi,int[] inor,int inlow,int inhi){
        if(prelow>prehi) return null;
        Node root = new Node(preor[prelow]);
        int i = inlow;
        while(inor[i] != preor[prelow]) i++;
        int lfetside = i-inlow;
        root.left = helper(preor, prelow+1, prelow+lfetside, inor, inlow, i-1);
        root.right = helper(preor, prelow+lfetside+1, prehi, inor, i+1, inhi);
        return root;
    }
    static Node buildNode(int[] preorder,int[] inOrder){
        int n = preorder.length-1;
        return  helper(preorder,0,n,inOrder,0,n);
    }
}
