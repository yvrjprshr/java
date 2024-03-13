package com.sde.day_26_dp;

class Solution {
    Boolean dp[][];
    public boolean memo(int sum, int i, int nums[]){
        if(sum == 0) return true;
        if(sum < 0) return false;
        if(i == nums.length) return false;
        if(dp[i][sum]!=null) return dp[i][sum];
        boolean take = memo(sum-nums[i], i+1, nums);
        boolean not_take = memo(sum, i+1, nums);
        dp[i][sum] = (take || not_take);
        return dp[i][sum];
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if(sum%2!=0)return false;
        sum /= 2;
        dp = new Boolean[nums.length+1][sum+1];
        return memo(sum,0,nums);
    }
}
