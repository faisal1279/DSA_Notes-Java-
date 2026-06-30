package BST;

public class sortedArrToBST {
    static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,5,9,10,11,12};
        Node root = sortedArrayToBST(arr);
        display(root);
    }
    public static void display(Node root){
        if(root == null) return;
        display(root.left);
        System.out.print(root.val+" ");
        display(root.right);
    }
    public static Node sortedArrayToBST(int[] arr){
        int n = arr.length;
        return convert(arr,0,n-1);
    }
    public static Node convert(int[] arr,int low,int hi){
        if(low>hi) return null;
        int mid = (low + hi)/2;
        Node root = new Node(arr[mid]);
        root.left = convert(arr, low, mid-1);
        root.right = convert(arr, mid+1, hi);
        return root;
    }

}
