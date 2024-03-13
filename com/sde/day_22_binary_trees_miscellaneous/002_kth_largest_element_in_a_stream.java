package com.sde.day_22_binary_trees_miscellaneous;

import java.util.*;

class KthLargest {
    
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    
    public int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        
        for(int num: nums){
            pq.offer(num);
        }
    }
    
    public int add(int val) {
        pq.add(val);
        
        while(pq.size()>k)pq.poll();
        
        return pq.peek();
    }
}