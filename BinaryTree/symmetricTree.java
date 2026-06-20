package binaryTree;

public class symmetricTree {
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
        Node b = new Node(2);                 // 2   2
        root.left = a;                          //   /\   /\
        root.right = b;                        //   3  4 4  3
        Node c = new Node(3);              //  \       /
        Node d = new Node(4);               //  5      5
        Node e = new Node(4);
        Node f = new Node(3);
        Node g = new Node(5);
        Node h = new Node(5);


        a.left = c;
        a.right = d;

        b.left = e;
        b.right = f;

        c.right = g;
        f.left = h;

        inOrder(root);
        System.out.println();
        Node temp = inverTreeFun(root.right);
        System.out.println(isSameTree(root.left,temp));
       
    }
    static boolean isSameTree(Node p,Node q){
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }
    static Node inverTreeFun(Node root){
        if(root == null) return root;
        Node l = root.left;
        Node r = root.right;
        root.left = inverTreeFun(r);
        root.right = inverTreeFun(l);
        return root;
    }
    static void inOrder(Node root){
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }
}
