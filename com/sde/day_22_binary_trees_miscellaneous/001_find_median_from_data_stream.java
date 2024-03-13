package com.sde.day_22_binary_trees_miscellaneous;

import java.util.*;

class MedianFinder {
    
    PriorityQueue<Integer> min_heap = new PriorityQueue<>();
    PriorityQueue<Integer> max_heap = new PriorityQueue<>(Collections.reverseOrder());

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        max_heap.add(num);
        min_heap.add(max_heap.poll());
        
        if(min_heap.size() > max_heap.size()){
            max_heap.add(min_heap.poll());
        }
    }
    
    public double findMedian() {
        if(min_heap.size() < max_heap.size()){
            return max_heap.peek();
        }
        return ((double)max_heap.peek()+(double)min_heap.peek())/2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */