package com.sde.day_25_dp;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
	public static int dp[][] = new int[1001][1001];
	public static int memo(ArrayList<Integer> values, ArrayList<Integer> weights, int i, int n, int w, int dp[][]){
		if(i == n || w <= 0) return 0;

		if(dp[i][w] != -1) return dp[i][w];

		int ans = 0;

		// take item
		if(weights.get(i) <= w){
			ans = Math.max(ans, values.get(i) + memo(values, weights, i+1, n, w-weights.get(i), dp));
		}

		// Do not take item
		ans = Math.max(ans, memo(values, weights, i+1, n, w, dp));

		dp[i][w] = ans;
		
		return ans;
	}
	public static int maxProfit(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w) {
		// Write your code here.
		int dp[][] = new int[values.size()][w+1];
		for(int i = 0; i < values.size(); i++)Arrays.fill(dp[i], -1);
		return memo(values, weights, 0, n, w, dp);
	}
}