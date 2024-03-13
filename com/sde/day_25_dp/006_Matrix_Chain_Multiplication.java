package com.sde.day_25_dp;
import java.util.*;
class Solution{
    public static int memo(int i, int j, int arr[], int dp[][]){
        if(i == j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int mini = Integer.MAX_VALUE;
        for(int k = i; k < j; k++){
            int steps = arr[i-1] * arr[k] * arr[j] + memo(i, k, arr, dp) + memo(k+1, j, arr, dp);
            mini = Math.min(mini, steps);
        }
        dp[i][j] = mini;
        return mini;
    }
    static int matrixMultiplication(int N, int arr[])
    {
        // code here
        int dp[][] = new int[101][101];
        for(int i = 0; i < dp.length; i++)Arrays.fill(dp[i], -1);
        return memo(1, arr.length-1, arr, dp);
    }
}