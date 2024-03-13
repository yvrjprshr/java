package com.sde.day_25_dp;
import java.util.*;
class Solution {
    public int dp[][] = new int[501][501];
    public int memo(String word1, String word2, int i, int j){
        if(i == word1.length() && j == word2.length()){
            return 0;
        }
        
        if(i == word1.length()){
            return word2.length()-j;
        }
        
        if(j == word2.length()){
            return word1.length()-i;
        }
        
        if(dp[i][j] != -1) return dp[i][j];
        
        int ans = Integer.MAX_VALUE;
        
        if(word1.charAt(i) == word2.charAt(j)){
            ans = Math.min(ans, memo(word1, word2, i+1, j+1));
        }
        
        ans = Math.min(ans, 1 + memo(word1, word2, i, j+1)); // insert
        ans = Math.min(ans, 1 + memo(word1, word2, i+1, j)); // Delete
        ans = Math.min(ans, 1 + memo(word1, word2, i+1, j+1)); // replace
        
        dp[i][j] = ans;
        
        return ans;
    }
    public int minDistance(String word1, String word2) {
        for(int i = 0; i < dp.length; i++) Arrays.fill(dp[i], -1);
        return memo(word1, word2, 0, 0);
    }
}