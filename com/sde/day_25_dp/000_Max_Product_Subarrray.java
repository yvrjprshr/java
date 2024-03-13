package com.sde.day_25_dp;

class Solution {
    public int maxProduct(int[] nums) {
        int ans = nums[0];
        int maxi = nums[0], mini = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            int temp_mini = mini, temp_maxi = maxi;
            maxi = Math.max(nums[i], Math.max(nums[i]*temp_mini, nums[i]*temp_maxi));
            mini = Math.min(nums[i], Math.min(nums[i]*temp_mini, nums[i]*temp_maxi));
            ans = Math.max(ans, maxi);
        }
        
        return ans;
    }
}