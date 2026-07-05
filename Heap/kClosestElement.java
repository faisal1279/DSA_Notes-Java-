package Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Pair implements Comparable<Pair>{
    int diff;
    int ele;
    public Pair(int diff,int ele) {
        this.diff = diff;
        this.ele = ele;
    }
    public int compareTo(Pair p){
        if(this.diff == p.diff) return this.ele - p.ele;
        return this.diff - p.diff;
    }
    
}
public class kClosestElement {
    public static void main(String[] args) {
        int[] arr = {10,1,4,3,2,8,6,9};
        int ele = 5;
        int k = 5;
        List<Integer> ans = findClosestElement(arr,ele,k);
        System.out.println(ans);
    }
    public static List<Integer> findClosestElement(int[] arr,int ele,int k){
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder()); // Max heap
        for(int a:arr){
            int res = a-ele;
            if(res<0) res = -res;
            pq.add(new Pair(res, a));
            if(pq.size() > k) pq.remove();
        }
        while(pq.size() > 0){
            Pair top = pq.remove();
            ans.add(top.ele);
        }
        return ans;

    }
}
