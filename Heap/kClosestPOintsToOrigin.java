package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

class Triplet implements Comparable<Triplet>{
    int dist;
    int x;
    int y;

    public Triplet(int dist,int x,int y) {
        this.dist = dist;
        this.x = x;
        this.y = y;
    }
    public int compareTo(Triplet t){
        return this.dist-t.dist;
    }
}
public class kClosestPOintsToOrigin {
    public static void main(String[] args) {
        // int[][] arr = {{3,3},{5,-1},{-2,4}};
        int[][] arr = {{1,3},{-2,2},{5,4},{0,1}};

        int k = 2;
        int[][] ans = kClosest(arr,k);
        for(int[] ele:ans){
            System.out.println(ele[0] +" "+ ele[1]);
        }
    }
    public static int[][] kClosest(int[][] arr,int k){
        PriorityQueue<Triplet> pq = new PriorityQueue<>(Collections.reverseOrder()); // Max heap
        for(int[] point:arr){
            int x = point[0], y = point[1];
            int dist = x*x + y*y;
            pq.add(new Triplet(dist, x, y));
            if(pq.size()>k) pq.remove();
        }
        int[][] ans = new int[k][2];
        for(int i=0;i<k;i++){
            Triplet top = pq.remove();
            int x = top.x;
            int y = top.y;
            ans[i][0] = x;
            ans[i][1] = y;
        }
        return ans;
    }
}
