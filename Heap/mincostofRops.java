package Heap;

import java.util.PriorityQueue;

public class mincostofRops {
    public static void main(String[] args) {
        int arr[] = {4,2,7,6,9};
        int cost = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0;i<arr.length;i++){
            pq.add(arr[i]);
        }
        while(pq.size()>2){
            int a = pq.remove() + pq.remove();
            cost += a;
            pq.add(a);
        }
        int a = pq.remove() + pq.remove();
        cost += a;
        System.out.println(cost);
    }
}
