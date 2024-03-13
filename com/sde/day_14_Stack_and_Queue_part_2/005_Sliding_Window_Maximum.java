package com.sde.day_14_Stack_and_Queue_part_2;
import java.util.*;
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int ans[] = new int[nums.length-k+1];
        int ind = 0;
        for(int i=0; i<nums.length; i++){
            if(!deque.isEmpty() && deque.peek()+k == i){
                deque.poll();
            }
            
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.pollLast();
            }
            
            deque.offer(i);
            
            if(i >= k-1){
                ans[ind] = nums[deque.peek()];
                ind++;
            }
        }
        
        return ans;
    }
}