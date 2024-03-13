package com.sde.day_8_greedy_algorithm;

import java.util.*;

class Solution{
    int dp[];
    public int rec(int coins[], int M, int V){
        if(V==0) return 0;
        if(dp[V]!=-1)return dp[V];
        int cnt = Integer.MAX_VALUE;
        for(int i=0; i<M; i++){
            if(coins[i] <= V){
                int remCoins = rec(coins, M, V-coins[i]);
                if(remCoins!=Integer.MAX_VALUE && cnt > remCoins+1){
                    cnt = 1 + remCoins;
                }
            }
        }
        dp[V]=cnt;
        return cnt;
    }

	public int minCoins(int coins[], int M, int V) 
	{ 
	    // Your code goes here
	    dp = new int[V+1];
	    Arrays.fill(dp, -1);
	    return rec(coins, M, V)==Integer.MAX_VALUE ? -1 : dp[V];
	}
}