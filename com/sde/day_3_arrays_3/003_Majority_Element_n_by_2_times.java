package com.sde.day_3_arrays_3;

import java.util.*;

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        
        for(int num: nums){
            if(hmap.get(num) == null){
                hmap.put(num, 1);
            }else{
                hmap.put(num, hmap.get(num)+1);
            }
            if(hmap.get(num) > nums.length/2) return num;
        }
        return -1;
    }
}


// Moore's Voting Algorithm

class Solution2 {
    public int majorityElement(int[] nums) {
        int majority_element = Integer.MIN_VALUE;
        int cnt = 0;
        for(int i=0; i<nums.length; i++){
            if(cnt == 0){
                majority_element = nums[i];
                cnt = 0;
            }
            
            if(nums[i] == majority_element){
                cnt++;
            }else{
                cnt--;
            }
        }
        
        return majority_element;
    }
}