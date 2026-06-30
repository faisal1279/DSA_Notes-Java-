package BST;

public class impelementBst {
    static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }
    public static void main(String[] args) {
        Node root = new Node(9);                // 9
        Node a = new Node(3);                 //  / \
        Node b = new Node(11);                 // 3   11
        root.left = a;                          //   /\   /\
        root.right = b;                        //   2  5 10 12     insert 12
        Node c = new Node(2);              //      \   
        Node d = new Node(5);               //      8  
        
        a.left = c;
        a.right = d;

        Node e = new Node(8);

        d.right = e;

        Node f = new Node(10);

        b.left = f;

        // inorder(root);
        // System.out.println();
        // System.out.println(min(root));
        // System.out.println();
        // System.out.println(max(root));
        // System.out.println(search(root,98));
        // System.out.println(getCountNode(root, 2, 8));
        // Node temp = attachNode(root,12);
        Node temp2 = attach2(root, 7);
        inorder(temp2);
    }
    static Node attach2(Node root,int key){
        if(root == null) return new Node(key);
        if(root.val < key){
            root.right = attach2(root.right, key);
        }else if(root.val > key) root.left = attach2(root.left, key);
        return root;
        
    }
    static void attach(Node root,int key){
        if(root == null) return;
        if(root.val == key) return;
        if(root.val < key){
            if(root.right == null) root.right = new Node(key);
            else attach(root.right, key);
        }else{
            if(root.left == null) root.left = new Node(key);
            else attach(root.left, key);
        }
    }
    static Node attachNode(Node root,int key){
        attach(root,key);
        return root;
    }
    static int getCountNode(Node root,int l,int h){
        if(root == null) return 0;
        if(root.val < l) return getCountNode(root.right, l, h);
        else if(root.val > h) return getCountNode(root.left, l, h);
        else{ //l>= root.data <=h
            return 1 + getCountNode(root.left, l, h) + getCountNode(root.right, l, h);
        }
    }
    static boolean search(Node root,int x){
        if(root ==null) return false;
        if(root.val == x) return true;
        else if(root.val < x){
           return search(root.right, x);
        }else{
           return search(root.left, x);
        }
    }
    static int min(Node root){
        Node temp = root;
        while(temp.left != null){
            temp = temp.left;
        }
        return temp.val;
    }
    static int max(Node root){
        Node temp = root;
        while(temp.right != null){
            temp = temp.right;
        }
        return temp.val;
    }
    static void inorder(Node root){
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);
    }
}
