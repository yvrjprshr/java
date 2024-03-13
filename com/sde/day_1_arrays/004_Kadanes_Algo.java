package com.sde.day_1_arrays;

class Solution {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        
        int temp = ans;
        
        for(int i=1; i<nums.length; i++){
            if(temp <= 0){
                temp = 0;
            }
            temp += nums[i];
            ans = Math.max(ans, temp);
        }
        return ans;
    }
}