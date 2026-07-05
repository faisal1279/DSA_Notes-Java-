package Heap;

import java.util.*;

class PairFreq implements Comparable<PairFreq>{
    int ele;
    int freq;
    PairFreq(int ele,int freq){
        this.ele = ele;
        this.freq = freq;
    }
    public int compareTo(PairFreq p){
        if(this.freq == p.freq) return this.ele - p.ele;
        return this.freq - p.freq;
    }
}
public class kFrequentElements {
    public static void main(String[] args) {
        int[] arr = {7,10,11,5,2,5,5,7,11,8,9};
        ArrayList<Integer> ans = topKFrequent(arr,4);
        System.out.println(ans);
    }
    static ArrayList<Integer> topKFrequent(int[] arr,int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int ele:arr){
            map.put(ele,map.getOrDefault(ele, 0)+1);
        }
        PriorityQueue<PairFreq> pq = new PriorityQueue<>();
        for(int ele:map.keySet()){
            int freq = map.get(ele);
            pq.add(new PairFreq(ele, freq));
            if(pq.size() > k) pq.remove();
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(pq.size()>0){
            PairFreq top = pq.remove();
            ans.add(top.ele);
        }
        Collections.reverse(ans);
        return ans;
    }
}
