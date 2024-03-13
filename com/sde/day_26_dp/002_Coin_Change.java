package com.sde.day_26_dp;
import java.util.*;
class Solution {
    int dp[][] = new int[13][10001];
    public int memo(int i, int coins[], int amount){
        if(amount == 0) return 0;
        if(amount < 0 || i == coins.length) return Integer.MAX_VALUE;
        if(dp[i][amount]!=-1)return dp[i][amount];
        int not_take = memo(i+1, coins, amount);
        int take = memo(i, coins, amount-coins[i]);
        if(take != Integer.MAX_VALUE){
            take += 1;
        }
        dp[i][amount]=Math.min(take,not_take);
        return dp[i][amount];
    }
    public int coinChange(int[] coins, int amount) {
        for(int i = 0; i < dp.length; i++) Arrays.fill(dp[i], -1);
        int res = memo(0, coins, amount);
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}