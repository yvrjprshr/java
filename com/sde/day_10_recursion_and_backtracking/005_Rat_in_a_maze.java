package com.sde.day_10_recursion_and_backtracking;
import java.util.*;
class Solution {
    public static void rec(int i, int j, int[][] m, int n, StringBuilder sb, ArrayList<String>ans, int vis[][]){
        if(i < 0 || j < 0 || i >= n || j >= n){
            return;
        }
        
        if(m[i][j] == 0){
            return;
        }
        
        if(vis[i][j]==1)return;
        
        if(i==n-1 && j==n-1){
            StringBuilder temp = new StringBuilder(sb);
            ans.add(temp.toString());
            return;
        }
        
        sb.append('D');
        vis[i][j]=1;
        rec(i+1, j, m, n, sb, ans, vis);
        vis[i][j]=0;
        sb.deleteCharAt(sb.length()-1);
        
        sb.append('U');
        vis[i][j]=1;
        rec(i-1, j, m, n, sb, ans, vis);
        vis[i][j]=0;
        sb.deleteCharAt(sb.length()-1);
        
        sb.append('L');
        vis[i][j]=1;
        rec(i, j-1, m, n, sb, ans, vis);
        vis[i][j]=0;
        sb.deleteCharAt(sb.length()-1);
        
        sb.append('R');
        vis[i][j]=1;
        rec(i, j+1, m, n, sb, ans, vis);
        vis[i][j]=0;
        sb.deleteCharAt(sb.length()-1);
    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        StringBuilder sb = new StringBuilder();
        ArrayList<String> ans = new ArrayList<>();
        int vis[][] = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(vis[i], 0);
        }
        rec(0, 0, m, n, sb, ans, vis);
        return ans;
    }
}
