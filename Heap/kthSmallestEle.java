package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class kthSmallestEle {
    public static void main(String[] args) {
        int arr[] = {7,10,4,3,20,15};
        System.out.println(smallestElement(arr,3));
        System.out.println(largestElement(arr,3));
        int arr2[] = {6,5,3,2,8,10,9};
        arr2 = nearlySortedArray(arr2,3);
        for(int ele:arr2){
            System.out.print(ele+" ");
        }
        System.out.println();
        int arr3[] = {2,7,4,1,8,1};
        System.out.println(lastStoneWeight(arr3));
        int arr4[] = {4,2,7,6,9};
        System.out.println(minimumCostofRopes(arr4));

    }
    static int minimumCostofRopes(int arr[]){
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // Min heap
        for(int ele:arr){
            pq.add(ele);
        }
        int ans = 0;
        while(pq.size() >1){
            int y = pq.remove();
            int x = pq.remove();
            pq.add(y+x);
        }
        if(pq.size() != 0) ans = pq.remove();
        return ans;
    }
    
    static int lastStoneWeight(int arr[]){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // Max heap
        for(int ele:arr){
            pq.add(ele);
        }
        int ans = 0;
        while(pq.size() >1){
            int y = pq.remove();
            int x = pq.remove();
            if(x!=y) pq.add(y-x);
        }
        if(pq.size() != 0) ans = pq.remove();
        return ans;
    }
    static int[] nearlySortedArray(int arr[],int k){
        int idx = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //Min Heap
            for(int ele:arr){
            pq.add(ele);
            if(pq.size() > k) arr[idx++] = pq.remove();
        }
        while(pq.size()>0){
            arr[idx++] = pq.remove();
        }
        return arr;
    }
    static int smallestElement(int[] arr,int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // Max heap
        for(int ele:arr){
            pq.add(ele);
            if(pq.size() > k) pq.remove();
        }
        return pq.peek();
    }
    static int largestElement(int[] arr,int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //Min Heap
        for(int ele:arr){
            pq.add(ele);
            if(pq.size() > k) pq.remove();
        }
        return pq.peek();
    }

}
