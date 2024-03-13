package com.sde.day23_graphs;

import java.util.Arrays;

class Solution {
    public boolean dfs(int x, int clr, int[][]graph, int color[]){
        color[x] = clr;
        for(int adj_node: graph[x]){
            if(color[adj_node]==-1){
                if(clr == 0){
                    if(dfs(adj_node, 1, graph, color)==false) return false;
                }else{
                    if(dfs(adj_node, 0, graph, color)==false) return false;
                }
            }else if(color[adj_node] == clr){
                return false;
            }
        }
        
        return true;
        
    }
    
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int color[] = new int[n];
        Arrays.fill(color, -1);
        for(int i=0;i<n;i++){
            if(color[i] == -1){
                boolean res = dfs(i, 0, graph, color);
                if(res == false){
                    return false;
                }
            }
        }
        return true;
    }
}