package com.sde.day23_graphs;

import java.util.ArrayList;
import java.util.Collections;

class Solution{
    public boolean dfs(int i, int parent, ArrayList<Boolean>vis, ArrayList<ArrayList<Integer>> adj){
        vis.set(i, true);
        for(Integer adj_node: adj.get(i)){
            if(vis.get(adj_node)==false){
                boolean res = dfs(adj_node, i, vis, adj);
                if(res)return true;
            }else if(parent != adj_node){
                return true;
            }
        }
        return false;
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj){
        ArrayList<Boolean> vis = new ArrayList<>();
        Collections.fill(vis, false);
        for(int i=0;i<V;i++){
            if(vis.get(i)==true)continue;
            boolean res = dfs(i, -1, vis, adj);
            if(res == true){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<4; i++){
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);

        Solution obj = new Solution();
        boolean res = obj.isCycle(4, adj);
        if(res){
            System.out.println("1");
        }else{
            System.out.println("0");
        }
    }
}