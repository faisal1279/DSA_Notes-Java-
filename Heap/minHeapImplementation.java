package Heap;

import java.util.Arrays;

class MinHeap{
    int[] arr;
    int idx = 1;
    int peak(){
        return arr[1];
    } 

    void display(){
        for(int i = 1;i<idx; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    MinHeap(int capacity){
        arr = new int[capacity + 1];
        Arrays.fill(arr, Integer.MIN_VALUE);
    }
    void add(int ele){
        arr[idx++] = ele;
        //rearrangement
        int root = idx-1;
        while(root != 1){
            int parent = root/2;
            if(arr[root] < arr[parent]){
                int temp = arr[root];
                arr[root] = arr[parent];
                arr[parent] = temp;
                root = parent;
            }else break;
        }
    }
    int size(){
        return idx-1;
    }
    int remove(){
        if(idx == 1) System.out.println("Your heap is empty");
        int min = arr[1];
        arr[1] = arr[idx-1];
        idx--;
        //rearrangement
        int root = 1;
        while(root <= size()){
            int left = 2*root;
            int right = 2*root + 1;
            int leftVal = (left <= size()) ? arr[left] : Integer.MAX_VALUE;
            int rightVal = (right <= size()) ? arr[right] : Integer.MAX_VALUE;

            if(arr[root] < leftVal && arr[root] < rightVal) break;
            else{
                if(leftVal < right){
                    int temp = arr[root];
                    arr[root] = arr[left];
                    arr[left] = temp;
                    root = left;
                }else{
                    int temp = arr[root];
                    arr[root] = arr[right];
                    arr[right] = temp;
                    root = right;
                }
            }
        }
        return min;
    }

}
public class minHeapImplementation {
    public static void main(String[] args) {
        MinHeap h = new MinHeap(10);
        h.add(10);
        h.add(15);
        h.add(8);
        h.add(9);
        h.display();
        System.out.println(h.remove());
        h.display();
        h.add(2);
        h.display();


    }
}
