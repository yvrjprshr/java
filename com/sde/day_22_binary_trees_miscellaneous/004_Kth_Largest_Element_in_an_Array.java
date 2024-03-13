package com.sde.day_22_binary_trees_miscellaneous;

import java.util.*;

class Solution {
    
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    
    public int findKthLargest(int[] nums, int k) {
        for(int num: nums){
            pq.add(num);
        }
        
        int num = pq.peek();
        int i = 0;
        while(i< k && !pq.isEmpty()){
            num = pq.poll();
            i++;
        }        
        return num;
    }
}