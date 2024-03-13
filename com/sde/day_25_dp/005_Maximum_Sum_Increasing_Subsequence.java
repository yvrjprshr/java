package com.sde.day_25_dp;
import java.util.*;
class Solution
{
    int dp[] = new int[1001];
    public int memo(int i, int arr[]){
        if(dp[i]!=-1)return dp[i];
        int ans = arr[i];
        for(int x = 0; x < i; x++){
            if(arr[x] < arr[i]){
                ans = Math.max(ans, arr[i] + memo(x, arr));
            }
        }
        dp[i]=ans;
        return ans;
    }
	public int maxSumIS(int arr[], int n)  
	{  
	    Arrays.fill(dp, -1);
	    int res = 0;
	    for(int i = 0; i < n; i++){
	        res = Math.max(res, memo(i, arr));
	    }
	    return res;
	}  
}