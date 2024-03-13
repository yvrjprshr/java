package com.sde.day_25_dp;
import java.util.Arrays;

// Recursive
class Solution {
    int dp[];
    public int rec(int x, int nums[]){
        int ans = 1;
        if(dp[x]!=-1)return dp[x];
        for(int i=0; i<x; i++){
            if(nums[i] < nums[x]){
                 ans = Math.max(ans, 1+rec(i, nums));
            }
        }
        return dp[x]=ans;
    }
    public int lengthOfLIS(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp,-1);
        int ans = 1;
        for(int i=0; i<nums.length; i++){
            ans = Math.max(ans, rec(i, nums));
        }
        return ans;
    }
}

// Iterative
class Solution2 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        for(int i=0;i<n;i++){
            dp[i]=1;
            for(int j=0; j<i; j++){
                if(nums[j] < nums[i]){
                    dp[i]=Math.max(dp[i], 1+dp[j]);
                }
            }
        }
        int max_lis = 1;
        for(int i:dp){
            max_lis = Math.max(max_lis, i);
        }
        return max_lis;
    }
}