package com.sde.day_25_dp;

import java.util.*;

class Solution {
    public int dp[][] = new int[1001][1001];
    public int lcs(String text1, String text2, int i, int j){
        if(i >= text1.length() || j >= text2.length()) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];
        int ans = 0;
        
        if(text1.charAt(i) == text2.charAt(j)){
            ans = Math.max(ans, 1 + lcs(text1, text2, i+1, j+1));    
        }else{
            ans = Math.max(ans, lcs(text1, text2, i, j+1));
            ans = Math.max(ans, lcs(text1, text2, i+1, j));
        }
        
        dp[i][j] = ans;
        return ans;
    }
    public int longestCommonSubsequence(String text1, String text2) {
        for(int i=0;i<dp.length;i++)Arrays.fill(dp[i], -1);
        return lcs(text1, text2, 0, 0);
    }
}