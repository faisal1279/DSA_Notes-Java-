package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class findMedian {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    public void addNum(int num){
        if(maxHeap.size() == 0) maxHeap.add(num);
        else{
            if(num < maxHeap.peek()) maxHeap.add(num);
            else minHeap.add(num);
        }
        if(maxHeap.size() == minHeap.size()+2){
            minHeap.add(maxHeap.remove());
        }
        if(minHeap.size() == maxHeap.size()+2){
            maxHeap.add(minHeap.remove());
        }
    }
    public double findMedianEle(){
        if(maxHeap.size() == minHeap.size()+1){
            return maxHeap.peek();
        }else if(minHeap.size() == maxHeap.size()+1){
            return minHeap.peek();
        }else{
            return (maxHeap.peek() + minHeap.peek())/2.0;
        }
    }
    public static void main(String[] args) {
        findMedian f = new findMedian();
        f.addNum(6);
        f.addNum(4);
        f.addNum(3);
        f.addNum(1);
        f.addNum(2);
        f.addNum(5);
        f.addNum(7);
        f.addNum(8);
        
        System.out.println(f.findMedianEle());


    }
}
