package com.sde.day_26_dp;
import java.util.*;
class Solution {
    int dp[][];
    public int memo(int i, int j, int sortedCuts[]){
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int mini = Integer.MAX_VALUE;
        for(int ind = i; ind <= j; ind++){
            int total = sortedCuts[j+1]-sortedCuts[i-1];
            total += memo(i, ind-1, sortedCuts);
            total += memo(ind+1, j, sortedCuts);
            mini = Math.min(mini, total);
        }
        dp[i][j]=mini;
        return mini;
    }
    public int minCost(int n, int[] cuts) {
        int sortedCuts[] = new int[cuts.length+2];
        sortedCuts[0]=0;
        for(int i = 1; i <= cuts.length; i++){
            sortedCuts[i]=cuts[i-1];
        }
        sortedCuts[cuts.length+1] = n;
        Arrays.sort(sortedCuts);
        int m = sortedCuts.length;
        dp = new int[m+1][m+1];
        for(int i = 0; i < dp.length; i++) Arrays.fill(dp[i], -1);
        return memo(1, cuts.length, sortedCuts);
    }
}
