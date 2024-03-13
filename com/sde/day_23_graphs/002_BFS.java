package com.sde.day23_graphs;

import java.util.*;

class Solution {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Boolean> vis = new ArrayList<>();
        for(int i=0;i<V;i++){
            vis.add(false);
        }
        Queue<Integer>q = new LinkedList<>();
        q.add(0);
        vis.set(0, true);
        
        while(!q.isEmpty()){
            int sz = q.size();
            for(int i=0; i<sz; i++){
                Integer node = q.poll();
                ans.add(node);
                for(Integer adj_node: adj.get(node)){
                    if(vis.get(adj_node)==false){
                        vis.set(adj_node, true);
                        q.add(adj_node);
                    }
                }
            }
        }
        return ans;
    }
}