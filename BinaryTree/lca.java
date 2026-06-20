package binaryTree;

public class lca {
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

        // Node res = lowestCommonAncestor(root,d,b);
        Node res = lowestCommonAncestor(root,c,d);
        System.out.println(res.val);
        
    }
    static Node lowestCommonAncestor(Node root,Node p,Node q){
        if(root == null) return null;
        if(root == p || root == q) return root;
        Node l = lowestCommonAncestor(root.left,p,q);
        Node r = lowestCommonAncestor(root.right,p,q);
        if((l != null) && (r != null)) return root;
        return (l==null) ? r : l;
    }
}
