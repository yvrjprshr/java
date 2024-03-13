package com.sde.day23_graphs;
import java.util.*;

class Solution {
    public void dfs(int node, ArrayList<Integer> ans, ArrayList<Boolean> vis, ArrayList<ArrayList<Integer>> adj){
        ans.add(node);
        vis.set(node, true);
        for(Integer adj_node: adj.get(node)){
            if(vis.get(adj_node)==false){
                dfs(adj_node, ans, vis, adj);
            }
        }
    }
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Boolean> vis = new ArrayList<>();
        for(int i=0;i<V;i++)vis.add(false);
        ArrayList<Integer> ans = new ArrayList<>();
        dfs(0, ans, vis, adj);
        return ans;
    }
}