package com.sde.day_3_arrays_3;

class Solution {
    int dp[][];
    public int helper(int i, int j, int m, int n){
        if(i < 0 || j < 0 || i >= m || j >= n) return 0;
        if(i == m-1 && j == n-1) return 1;
        if(dp[i][j]!=-1)return dp[i][j];
        int dir[][] = new int[][]{{1, 0}, {0, 1}};
        int ans = 0;
        for(int x=0; x<dir.length; x++){
            ans += helper(i+dir[x][0], j+dir[x][1], m, n);
        }
        return dp[i][j]=ans;
    }
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        return helper(0, 0, m, n);
    }
}  