package com.sde.day_26_dp;
import java.util.*;
class Solution {
    //Function to find minimum number of attempts needed in 
    //order to find the critical floor.
    static int memo(int eggs, int floors, int dp[][]){
        if(floors == 1 || floors == 0) return floors;
        if(eggs == 1) return floors;
        if(dp[eggs][floors] != -1) return dp[eggs][floors];
        int ans = Integer.MAX_VALUE;
        for(int i = 1; i <= floors; i++){
            int temp = 1 + Math.max(memo(eggs-1, i-1, dp), memo(eggs, floors-i, dp));
            ans = Math.min(ans, temp);
        }
        dp[eggs][floors]=ans;
        return ans;
    }
    static int eggDrop(int n, int k) 
	{
	    // Your code here
	    int dp[][]=new int[n+1][k+1];
	    for(int i = 0; i <= n; i++)Arrays.fill(dp[i],-1);
	    return memo(n,k,dp);
	}
}