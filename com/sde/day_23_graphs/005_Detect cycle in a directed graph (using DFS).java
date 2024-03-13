package com.sde.day23_graphs;

import java.util.ArrayList;

class Solution{

    public boolean dfs(int node, ArrayList<ArrayList<Integer>>adj, boolean vis[], boolean pathVis[]){
        pathVis[node]=true;
        vis[node]=true;
        for(int adj_node: adj.get(node)){
            if(vis[adj_node]==false){
                boolean res = dfs(adj_node, adj, vis, pathVis);
                if(res){
                    return true;
                }
            }else if(pathVis[adj_node]){
                return true;
            }
        }
        pathVis[node]=false;
        return false;
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>>adj){
        boolean vis[] = new boolean[V];
        boolean pathVis[] = new boolean[V];
        for(int i=0; i<V; i++){
            if(vis[i]==false){
                boolean res = dfs(i, adj, vis, pathVis);
                if(res){
                    return true;
                }
            }
        }
        return false;
        
    }

    public static void main(String[] args) {
        int V = 11;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(3).add(7);
        adj.get(4).add(5);
        adj.get(5).add(6);
        adj.get(7).add(5);
        adj.get(8).add(9);
        adj.get(9).add(10);
        adj.get(10).add(8);

        Solution obj = new Solution();
        boolean res = obj.isCycle(V, adj);
        if(res){
            System.out.println("True");
        }else{
            System.out.println("False");
        }
    }
}