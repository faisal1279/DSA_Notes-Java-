package Heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

class Triplet implements Comparable<Triplet>{
    int ele;
    int row;
    int col;

    public Triplet(int ele,int row,int col) {
        this.ele = ele;
        this.row = row;
        this.col = col;
    }
    public int compareTo(Triplet t){
        return this.ele - t.ele;
    }
    
}
public class findSmallestRangeEle {
    public static ArrayList<Integer> findSmallestRange(int[][] arr){
        int k = arr.length,n = arr[0].length;
        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int i=0;i<k;i++){
            max = Math.max(max,arr[i][0]);
            min = Math.min(min,arr[i][0]);
            pq.add(new Triplet(arr[i][0],i,0));
        }
        int a = min;
        int b = max;
        while(true){
            Triplet top = pq.remove();
            int ele = top.ele;int row = top.row; int col = top.col;
            if((max-ele) < (b-a)){
               a = ele;
               b = max;
            }
            if(col == n-1) break;
            int next = arr[row][col+1];
            max = Math.max(max,next);
            pq.add(new Triplet(next, row, col+1));
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(a);
        ans.add(b);
        return ans;
    }
    public static void main(String[] args) {
        int[][] arr = {{4,7,9,12,15},
                    {0,8,10,14,20},
                    {6,12,16,30,50}};
        ArrayList<Integer> ans = findSmallestRange(arr);
        System.out.println(ans);
    }
}
