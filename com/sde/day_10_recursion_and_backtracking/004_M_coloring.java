package com.sde.day_10_recursion_and_backtracking;

import java.util.*;

class solve {
    
    public boolean rec(int node, List<List<Integer>> adj, int m, int n, int color[]){
        if(node == n) return true;
        for(int i=0;i<m;i++){
            boolean isValid = true;
            for(int x : adj.get(node)){
                if(color[x] == i) isValid = false;
            }
            if(isValid){
                color[node]=i;
                if(rec(node+1, adj, m, n, color))return true;
                color[node]=-1;
            }
        }
        return false;
    }
    
    public boolean graphColoring(boolean graph[][], int m, int n) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(graph[i][j]==true){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        
        int color[] = new int[n];
        Arrays.fill(color, -1);       
        return rec(0, adj, m, n, color);
    }
}