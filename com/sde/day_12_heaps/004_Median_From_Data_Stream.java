package com.sde.day_12_heaps;
import java.util.*;
class MedianFinder {
    class CustomComparator implements Comparator<Integer>{
        public int compare(Integer a, Integer b){
            return b-a;
        }
    } 
    
    PriorityQueue<Integer> min_heap = new PriorityQueue<>();
    PriorityQueue<Integer> max_heap = new PriorityQueue<>(new CustomComparator());
    
     
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {

        // max_heap will store top half minimum elemmts in descending order
        // min_heap will store max elements in ascending order
        // so first add all elemtns in max_hap and store top maximum element in min_heap
        max_heap.add(num);
        min_heap.add(max_heap.poll());
        
        if(min_heap.size() > max_heap.size()){
            max_heap.add(min_heap.poll());
        }
    }
    
    public double findMedian() {        
        if(max_heap.size() > min_heap.size()){
            return max_heap.peek();
        }
        
        int a = max_heap.peek();
        int b = min_heap.peek();
        
        double ans = ((a+b))/2.0;
        
        return ans;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */